package com.liuym.test;

import com.liuym.entity.Person;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.*;

/**
 * @author LiuYiMing
 * @date 2018/10/18 14:12
 * @describe：
 */

public class testLambda {

    @Test
    public void testBaseLambda() {

    }

    List<Person> javaProgrammers = new ArrayList<Person>() {
        {
            add(new Person("Elsdon", "Java", "male", 43, 2000));
            add(new Person("Tamsen", "Java ", "female", 23, 1500));
            add(new Person("Floyd", "Java ", "male", 33, 1800));
            add(new Person("Sindy", "Java ", "female", 32, 1600));
            add(new Person("Vere", "Java ", "male", 22, 1200));
            add(new Person("Maude", "Java ", "female", 27, 1900));
            add(new Person("Shawn", "Java ", "male", 30, 2300));
            add(new Person("Jayden", "Java ", "female", 35, 1700));
            add(new Person("Palmer", "Java ", "male", 33, 2000));
            add(new Person("Addison", "Java ", "female", 34, 1300));
            add(new Person("Addison", "Java ", "female", 34, 1300));
        }
    };
    List<Person> phpProgrammers = new ArrayList<Person>() {
        {
            add(new Person("Jarrod", "PHP ", "male", 34, 1550));
            add(new Person("Clarette", "PHP ", "female", 23, 1200));
            add(new Person("Victor", "PHP ", "male", 32, 1600));
            add(new Person("Tori", "PHP ", "female", 21, 1000));
            add(new Person("Osborne", "PHP ", "male", 32, 1100));
            add(new Person("Rosalind", "PHP ", "female", 25, 1300));
            add(new Person("Fraser", "PHP ", "male", 36, 1100));
            add(new Person("Quinn", "PHP ", "female", 21, 1900));
            add(new Person("Alvin", "PHP ", "male", 38, 1600));
            add(new Person("Evonne", "PHP ", "female", 40, 1800));
        }
    };

    @Test
    public void testArrayFor() {
        String[] pla = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};
        List<String> players = Arrays.asList(pla);
        //一般写法
        for (String name : players) {
            System.out.println(name + ";");
        }
        //lambda写法
        //players.forEach((player) -> System.out.println(player + ";"));
        //java8 :: 写法
        // players.forEach(System.out::println);
    }

    @Test
    public void testArraySort() {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};
        /**
         * 使用原始方法
         */
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1.compareTo(o2));
            }
        });
        for (String s1 : players) {
            System.out.println(s1 + " base");
        }
        /**
         * 使用lambda方法
         */
        Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));
        for (String s2 : players) {
            System.out.println(s2 + " lambda");
        }
    }

    @Test
    public void testRunable() {
        /**
         * 使用原始方法
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("testRunableByBase");
            }
        }).start();
        /**
         * 使用lambda方法
         */
        new Thread(() -> System.out.println("testRunableByLambda")).start();
        /**
         * 使用匿名内部类的方法
         */
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("testRunableByInnerClass");
            }
        };
        runnable1.run();
        /**
         * 使用lambda方法
         */
        Runnable runnable2 = () -> System.out.println("testRunableByLambdaInnerClass");
        runnable2.run();
    }

    @Test
    public void testLambda() {

        System.out.println("所有程序员的名字：");
        javaProgrammers.forEach((person) -> System.out.println(person.getUserName() ));
        phpProgrammers.forEach((person -> System.out.println(person.getUserName() )));

        System.out.println("给所有程序员加薪5%:");
        javaProgrammers.forEach((e) -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary()));
        phpProgrammers.forEach((e) -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary()));
        javaProgrammers.forEach((person) -> System.out.println(person.getSalary()));
        phpProgrammers.forEach((person -> System.out.println(person.getSalary())));
    }

    @Test
    public void testStream() {
        System.out.println("月薪超过1400的php程序员:");
        phpProgrammers.stream()
                .filter((p) -> (p.getSalary() > 1400))
                .forEach((p) -> System.out.println(p.getUserName()+ "\t" + p.getSalary()));

        System.out.println("下面是年龄大于 24岁且月薪在$1,400以上的女PHP程序员:");
        phpProgrammers.stream()
                .filter((person -> (person.getAge() > 25)))
                .filter((person -> (person.getSalary() > 1400)))
                .filter((person -> ("female".equals(person.getSex()))))
                .forEach((person -> System.out.println(person.getUserName()
                        + person.getAge() + " "
                        + person.getSalary() + " "
                        + person.getSex())));

        System.out.println("下面是最前面的3个java程序员：");
        javaProgrammers.stream().limit(3).forEach(person -> System.out.println(person.getUserName()+" "+person.getSex()));

        System.out.println("下面是最前面的3个java女程序员:");
        javaProgrammers.stream()
                .filter((person -> ("female".equals(person.getSex()))))
                .limit(3)
                .forEach(person -> System.out.println(person.getUserName() + " " + person.getSex()));

        System.out.println("根据 name 排序,并显示前5个 Java 程序员:");
        javaProgrammers.stream()
                .sorted((p1, p2) -> (p1.getUserName().compareTo(p2.getUserName())))
                .limit(5)
                .collect(toList())
                .forEach((person -> System.out.println(person.getUserName())));

        System.out.println("根据工资排序java程序员:");
        javaProgrammers.stream()
                .sorted((p1, p2) -> {
                    return (p2.getSalary() - p1.getSalary());
                })
                .collect(toList())
                .forEach((person -> {
                    System.out.println(person.getUserName() + " " + person.getSalary());
                }));

        System.out.println("工资最低的java程序员");
        Person personMix = javaProgrammers.stream()
                .min((p1, p2) -> (p1.getSalary() - p2.getSalary()))
                .get();
        System.out.println(personMix.getUserName()+ " " + personMix.getSalary());

        System.out.println("工资最高的java程序员");
        Person personMax = javaProgrammers.stream()
                .max((p1, p2) -> (p1.getSalary() - p2.getSalary()))
                .get();
        System.out.println(personMax.getUserName()+ " " + personMax.getSalary());

        System.out.println("将php程序员的FristName转化成string:");
        String phpDevelopers = phpProgrammers
                .stream()
                .map(Person::getUserName)
                .collect(joining(" ; "));
        System.out.println(phpDevelopers);

        System.out.println("将 Java 程序员 的  username 存放到 Set:");
        Set<String> javaUserNameSet = javaProgrammers.stream()
                .map(Person::getUserName)
                .collect(toSet());
        System.out.println(javaUserNameSet);


    }


}
