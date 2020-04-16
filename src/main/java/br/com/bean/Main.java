package br.com.bean;

import br.com.bean.model.ItemVenda;
import br.com.bean.model.TipoVenda;
import br.com.bean.model.Venda;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        ItemVenda item = new ItemVenda();
        item.setDescricao("Camisa Corinthians");
        item.setPreco(250.0F);
        item.setQuantidade(1);

        Venda venda = new Venda();
        venda.setData(Calendar.getInstance().getTime());
        venda.setTipo(TipoVenda.VendaBrinde);
        venda.setTotal(1);
        venda.setItens(new ArrayList<ItemVenda>(){{
            add(item);
        }});

        Set<ConstraintViolation<Venda>> violation = validator.validate(venda);
        violation.stream().map(constraintViolation -> "Erro: " + constraintViolation.getMessage()
                        + " ["
                        + constraintViolation.getRootBeanClass().getSimpleName()
                        + ", "
                        + constraintViolation.getPropertyPath()
                        + "]"
                 ).forEachOrdered(System.out::println);
    }
}
