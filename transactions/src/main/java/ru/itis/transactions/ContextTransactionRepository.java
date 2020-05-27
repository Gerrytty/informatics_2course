package ru.itis.transactions;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Data
public class ContextTransactionRepository {

    private ArrayList<Method> methods;

    public ContextTransactionRepository() {
        methods = new ArrayList<>();
    }

    public boolean consists(Method method) {
        return methods.contains(method);
    }

    public void save(Method method) {
        methods.add(method);
    }

    public Object getReturnedValue(Method method) {
        for (Method m : methods) {
            if(m.equals(method)) {
                return m.getReturnedValue();
            }
        }
        return null;
    }

}
