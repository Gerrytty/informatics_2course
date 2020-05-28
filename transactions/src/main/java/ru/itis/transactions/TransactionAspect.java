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

        Method method = new Method(uuid, jp.getSignature().getName());

        if(!contextTransactionRepository.contains(method)) {

            Optional<MethodEntity> methodEntity = transactionsRepository.findByUuid(uuid);

            if(methodEntity.isPresent()) {
                Object returned = methodEntity.get().getReturnedValue().equals("null") ? null :
                        objectMapper.readValue(methodEntity.get().getReturnedValue(),
                        ((MethodSignature) jp.getSignature()).getReturnType());

                method.setReturnedValue(returned);
                contextTransactionRepository.save(method);

                return returned;
            }

            else {
                transactionsRepository.save(MethodEntity.from(method));
                return jp.proceed();
            }
        }

        else {
            return contextTransactionRepository.getReturnedValue(method);
        }

    }


}
