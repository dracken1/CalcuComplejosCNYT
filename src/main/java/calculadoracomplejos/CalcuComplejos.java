/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoracomplejos;


public class CalcuComplejos {
    public double pReal;
    public double pImaginaria;
    
    public CalcuComplejos(double real, double imaginario){
        pReal = real;
        pImaginaria = imaginario;
    }
    
    
    public CalcuComplejos suma(CalcuComplejos n1){
        
        return new CalcuComplejos(pReal+n1.getParteReal(),pImaginaria+n1.getParteImaginaria());
    }
    
    
    public CalcuComplejos producto(CalcuComplejos n1){
        double real;
        double imaginaria;
        
        real = (n1.getParteReal() * this.pReal) - (n1.getParteImaginaria() * this.pImaginaria) ;
        imaginaria = (n1.getParteImaginaria() * this.pReal) + (n1.getParteReal() * this.pImaginaria);
        
        return new CalcuComplejos(real,imaginaria);
    }
    
    
    public CalcuComplejos resta(CalcuComplejos n1){
        
        return new CalcuComplejos(pReal-n1.getParteReal(),pImaginaria-n1.getParteImaginaria());
    }
    
    
    public CalcuComplejos division(CalcuComplejos n1){
        double real;
        double imaginaria;
        double div;
        
        real = (n1.getParteReal()*this.pReal)+(n1.getParteImaginaria()*this.pImaginaria);
        imaginaria = (n1.getParteReal()*this.pImaginaria) - (this.pReal*n1.getParteImaginaria());
        
        div = (n1.getParteReal()*n1.getParteReal()) + (n1.getParteImaginaria()*n1.getParteImaginaria());
        
        real = real/div;
        imaginaria = imaginaria/div;
        
        return new CalcuComplejos(real,imaginaria);
    }
    
    
    public double modulo(){
        double modulo;
        
        modulo = Math.sqrt((this.pReal*this.pReal)+(this.pImaginaria*this.pImaginaria));        
        modulo = Math.round(modulo * 100);
        modulo = modulo / 100 ;
        
        return (modulo) ;
    }
    
    
    public double fase(){
        double fase;
        
        fase = (Math.atan(this.pImaginaria/this.pReal));
        fase = Math.round(fase * 100);
        fase = fase / 100 ;
        
        return fase;
    }
    
    
    public CalcuComplejos conjugado(){
        return new CalcuComplejos(this.pReal,-this.pImaginaria);
    }
    
    
    public CalcuComplejos inverso(){
        return new CalcuComplejos(-this.pReal,-this.pImaginaria);
    }
    
    
    public String polar(){
        double modulo;
        double fase;
        
        modulo = modulo();
        fase = fase();
        
        return (Double.toString(modulo)+","+Double.toString(fase));
    }
    
    
    public Double norma(){
        return Math.sqrt((pReal*pReal)+(pImaginaria*pImaginaria));
    }
    
    
    public boolean equals(CalcuComplejos n1){
        if (n1.getParteReal() == this.getParteReal() && n1.getParteImaginaria() == this.getParteImaginaria()){
            return true;
        }
        return false;
    }
    
    public double getParteReal(){
        return pReal;
    }
    
    public double getParteImaginaria(){
        return pImaginaria;
    }
}
