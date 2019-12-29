package com.atguigu.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * ˮ����ɫע��
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
	
	/**
	 * ��ɫö��
	 */
	public enum Color{ BLUE,RED,GREEN};
	/**
	 * ��ɫ����
	 */
	Color fruitColor() default Color.GREEN;

}
