package com.mycompany.bevitori;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        

        Monitor s=new Monitor(1);
        Botte bx=new Botte();

        Bevitore m1=new Bevitore("pippo",bx,s);
        Bevitore m2=new Bevitore("fra",bx,s);
        Bevitore m3=new Bevitore("franco",bx,s);
        Bevitore m4=new Bevitore("riccardo",bx,s);

        m1.start();
        m2.start();
        m3.start();
        m4.start();

        /* 
            la funzione join() blocca il chiamante fino a che il thread sul quale
            si chiama join() non termina la propria esecuzione
        */
        m1.join();
        m2.join();
        m3.join();
        m4.join();
        System.out.println("vino finito");
    }
}
