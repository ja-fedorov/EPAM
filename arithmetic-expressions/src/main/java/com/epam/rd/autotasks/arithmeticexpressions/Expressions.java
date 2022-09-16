package com.epam.rd.autotasks.arithmeticexpressions;

import java.util.StringJoiner;

public class Expressions {

    public static Variable var(String name, int value) {
        return new Variable(name, value);
    }

    public static Expression val(int value) {
        return new Expression () {

            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                if (value<0) {
                    return "(" + value + ")";
                }
                return Integer.toString(value);
            }
        };
    }

    public static Expression sum(Expression... members){
        return new Expression() {

            @Override
            public int evaluate() {
                int sum = 0;
                for (Expression member : members) {
                    if (member !=null) {
                        sum += member.evaluate();  // Мы не можем напрямую задать member, а его достать можем через метод evalute ();
                    }
                }
                return sum;
            }

            @Override
            public String toExpressionString() {
                StringBuilder sb = new StringBuilder ();
                sb.append("(");
                for (int i = 0; i <members.length; i++) {
                    sb.append(members[i].toExpressionString());
                    if (i != members.length-1) {
                        sb.append (" + ");
                    }
                }
                sb.append(")");
                return sb.toString();
            }
        };
    }

    public static Expression product(Expression... members) {
        return new Expression() {

            @Override
            public int evaluate() {
                int product = 1;
                for (Expression e : members) {
                    if (e != null) {
                        product *= e.evaluate();
                    }
                }
                return product;
            }

            @Override
            public String toExpressionString() {
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                for (int i = 0; i < members.length; i++) {
                    sb.append(members[i].toExpressionString());
                    if (i != members.length - 1) {
                        sb.append(" * ");
                    }
                }
                sb.append(")");
                return sb.toString();
            }
        };
    }

    public static Expression difference(Expression minuend, Expression subtrahend){
        return new Expression () {
            @Override
            public int evaluate() {
                return minuend.evaluate() - subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                StringBuilder sb = new StringBuilder ();
                sb.append("(");
                sb.append(minuend.toExpressionString());
                sb.append(" - ");
                sb.append(subtrahend.toExpressionString());
                sb.append(")");

                return sb.toString();


            }
        };
    }

    public static Expression fraction(Expression dividend, Expression divisor){
    return new Expression () {
        @Override
        public int evaluate() {
            return dividend.evaluate() / divisor.evaluate();
        }

        @Override
        public String toExpressionString() {
            StringBuilder sb = new StringBuilder ();
            sb.append("(");
            sb.append(dividend.toExpressionString());
            sb.append (" / ");
            sb.append(divisor.toExpressionString());
            sb.append(")");

            return sb.toString();
        }
    };
    }

}
