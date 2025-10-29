package com.generation.gestaorh.record;

import java.math.BigDecimal;

public record Holerite(
		BigDecimal salario,
		int horasExtras,
		BigDecimal valorHoraExtra,
		BigDecimal valorTotalHorasExtras,
	    BigDecimal inss,
	    BigDecimal irrf,
	    BigDecimal totalDescontos,
	    BigDecimal salarioLiquido
	    ) 
{}
