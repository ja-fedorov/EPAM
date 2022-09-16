package com.shpp.p2p.cs.yfedorov.assignment3;

public class TEST {
    public static void main(String[] args) {
        class A {
            public void sayHello() {
                System.out.println("Hello from A");
            }
        }

        class B extends A {
            public void sayHello() {
                System.out. println("Hello from B");
            }
        }


        public class Main {
            public static void main(String[] args) {
                A x1 = new A();
                x1.sayHello();

                B x2 = new B();
                x2.sayHello();

                B x3 = new A();
                x3.sayHello();

            }
        }

    }
}
