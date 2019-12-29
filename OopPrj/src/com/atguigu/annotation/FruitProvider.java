package com.atguigu.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * ˮ����Ӧ��ע��
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {

	/**
	 * ��Ӧ�̱��
	 */
	public int id() default -1;
	/**
	 * ��Ӧ������
	 */
	public String name() default "";
	/**
	 * ��Ӧ�̵�ַ
	 */
	public String address() default "";
}
