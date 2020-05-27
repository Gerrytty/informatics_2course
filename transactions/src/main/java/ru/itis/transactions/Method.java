package ru.itis.transactions;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class Method {

    private String name;
    private Object returnedValue;
    private String uuid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Override
    public boolean equals(Object o) {
        return (o instanceof Method) && uuid.equals(((Method) o).uuid) && name.equals(((Method) o).name);
    }

    public Method(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

}
