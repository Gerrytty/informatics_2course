package ru.itis.transactions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "method")
public class MethodEntity {

    private String name;
    private String returnedValue;
    private String uuid;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public static MethodEntity from(Method method) {
        try {
            return MethodEntity.builder()
                    .uuid(method.getUuid())
                    .name(method.getName())
                    .returnedValue(objectMapper.writeValueAsString(method.getReturnedValue()))
                    .build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
