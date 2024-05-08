package com.mycompany.bevitori;

public class Botte 
{
    private int quantita;
    private int n_persone;
    

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Botte() {
        this.quantita = 100;
    }

    public int getN_persone() {
        return n_persone;
    }

    public void setN_persone(int n_persone) {
        this.n_persone = n_persone;
    }
    public void bevuta(Bevitore a)
    {
        int sec=(int) (Math.random()*3)+2;
        sec=sec*1000;
        try 
        {
            Thread.sleep(sec);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        
        System.out.println("----"+Thread.currentThread().getName() + " sta bevendo ----");
        int bevuta=(int) (Math.random()*3)+1;
        
        this.setQuantita(this.quantita-bevuta);
        System.out.println(a.getNome()+"\n");
        System.out.println(quantita);
        this.setN_persone(this.n_persone-1);
        
    }
    
}
