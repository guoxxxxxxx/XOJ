/**
 * @Time: 2024/3/29 19:11
 * @Author: guoxun
 * @File: ListValueConstraintValidator
 * @Description:
 */

package com.pipi.xoj.common.valid.custom.validater;

import com.pipi.xoj.common.valid.custom.ListValue;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.Set;

public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {

    private Set<Integer> set = new HashSet<>();

    // init method
    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] vals = constraintAnnotation.vals();
        for (int val : vals){
            set.add(val);
        }
    }

    // Check whether the verification is successful
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return false;
    }
}
