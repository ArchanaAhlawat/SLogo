package test;

//https://www.javaworld.com/article/2074753/core-java/object-hacking-in-java---power-of-reflection.html

import java.lang.reflect.Field;

public class Emp 
{
	private String name = "John";
	private int age = 23;
	private Integer sal = new Integer(5000);
	private Double incentive = new Double("12345.567");
	private boolean isEmployee = true;
}