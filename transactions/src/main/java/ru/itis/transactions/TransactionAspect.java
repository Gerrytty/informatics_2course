package ru.itis.transactions;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Aspect
@Component
public class TransactionAspect {

    private final ContextTransactionRepository contextTransactionRepository;
    private final TransactionsRepository transactionsRepository;

    private ObjectMapper objectMapper;

    public TransactionAspect(ContextTransactionRepository contextTransactionRepository, TransactionsRepository transactionsRepository) {
        this.contextTransactionRepository = contextTransactionRepository;
        this.transactionsRepository = transactionsRepository;
        objectMapper = new ObjectMapper();
    }


    @Pointcut("@annotation(MyTransaction) && args(uuid, ..)")
    public void callAspect(String uuid) { }

    @Around("callAspect(uuid)")
    public Object beforeCallAtMethod(ProceedingJoinPoint jp, String uuid) throws Throwable {

        Method method = new Method();
        method.setName(jp.getSignature().getName());
        method.setUuid(uuid);

        if(!contextTransactionRepository.consists(method)) {
            Object returned = jp.proceed();
            method.setReturnedValue(returned);
            contextTransactionRepository.save(method);

            Optional<MethodEntity> methodEntity = transactionsRepository.findByUuid(method.getUuid());

            if(methodEntity.isPresent()) {
                return objectMapper.readValue(methodEntity.get().getReturnedValue(),
                        ((MethodSignature) jp.getSignature()).getReturnType());
            }

            else {
                transactionsRepository.save(MethodEntity.from(method));
            }

            return returned;
        }

        else {
            return contextTransactionRepository.getReturnedValue(method);
        }

    }


}
