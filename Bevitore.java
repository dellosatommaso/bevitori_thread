package com.mycompany.bevitori;

public class Bevitore extends Thread
{
    private String nome;
    private Botte botte;
    private Monitor s;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Botte getBotte() {
        return botte;
    }

    public void setBotte(Botte botte) {
        this.botte = botte;
    }

    public Monitor getS() {
        return s;
    }

    public void setS(Monitor s) {
        this.s = s;
    }

    public Bevitore(String nome, Botte botte, Monitor s) {
        this.nome = nome;
        this.botte = botte;
        this.s = s;
        this.setName(nome);
    }
    @Override
    public void start()
    {
        while(botte.getQuantita()>0)
        {
            botte.setN_persone(botte.getN_persone()+1);
            if(botte.getN_persone()>3)
            {
                s.P();
            }
            else
            {
                if(this.getBotte().getQuantita()<=0)
                {
                    this.interrupt();
                }
                else
                {
                    this.getBotte().bevuta(this);
                    //s.P();
                    s.V();
                }
            }
            
        }
            
    }
    

}
