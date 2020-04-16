package br.com.bean.model.validacao.venda;

import br.com.bean.model.TipoVenda;
import br.com.bean.model.Venda;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TotalPorTipoValidator implements ConstraintValidator<TotalPorTipo, Venda> {
    @Override
    public void initialize(TotalPorTipo constraintAnnotation) {

    }

    @Override
    public boolean isValid(Venda venda, ConstraintValidatorContext constraintValidatorContext) {
        if (venda == null) {
            return false;
        }

        boolean valido = false;

        if (venda.getTipo() == TipoVenda.VendaPadrao && venda.getTotal() > 0) {
            valido = true;
        }

        if (venda.getTipo() == TipoVenda.VendaBrinde && venda.getTotal() == 0) {
            valido = true;
        }
        return valido;
    }
}
