package com.github.nalukit.malio.processor.constraints;

import com.github.nalukit.malio.processor.Constants;
import com.github.nalukit.malio.processor.constraints.generator.AbstractGenerator;
import com.github.nalukit.malio.processor.constraints.generator.ConstraintMaxDecimalValueGenerator;
import com.github.nalukit.malio.processor.model.ConstraintType;
import com.github.nalukit.malio.processor.util.ProcessorUtils;
import com.github.nalukit.malio.shared.annotation.field.DecimalMaxValue;
import com.github.nalukit.malio.shared.internal.constraints.AbstractMaxDecimalValueConstraint;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import java.math.BigDecimal;
import java.util.List;

public class MaxDecimalValueConstraint extends AbstractConstraint<DecimalMaxValue> {

    public MaxDecimalValueConstraint(ProcessingEnvironment processingEnv, ProcessorUtils processorUtils) {
        super(processingEnv, processorUtils);
    }

    @Override
    public Class<DecimalMaxValue> annotationType() {
        return DecimalMaxValue.class;
    }

    @Override
    public String getImplementationName() {
        return Constants.MALIO_CONSTRAINT_MAXDECIMALVALUE_IMPL_NAME;
    }

    @Override
    public ConstraintType getConstraintType() {
        return ConstraintType.MAX_DECIMAL_VALUE_CONSTRAINT;
    }

    @Override
    public TypeName getValidationClass(VariableElement variableElement) {
        return ClassName.get(AbstractMaxDecimalValueConstraint.class);
    }

    @Override
    protected List<TypeKind> getSupportedPrimitives() {
        return null;
    }

    @Override
    protected List<Class> getSupportedDeclaredType() {
        return List.of(BigDecimal.class);
    }

    @Override
    protected AbstractGenerator createGenerator() {
        return ConstraintMaxDecimalValueGenerator.builder()
                .elements(this.processingEnvironment.getElementUtils())
                .filer(this.processingEnvironment.getFiler())
                .types(this.processingEnvironment.getTypeUtils())
                .processorUtils(this.processorUtils)
                .constraint(this)
                .build();
    }


}
