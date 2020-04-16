package br.com.bean.model.validacao.venda;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {TotalPorTipoValidator.class})
@Documented
public @interface TotalPorTipo {
    String message() default "{br.com.bean.Venda.TIPO}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
