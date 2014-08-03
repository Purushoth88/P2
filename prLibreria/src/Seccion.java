
public enum Seccion {
	literatura,novedades,infantil,cocina;
	
	
    static Seccion OpcoesMenu(String valorOpcao){
        if(literatura.toString().equalsIgnoreCase(valorOpcao)) return literatura;
        else if(novedades.toString().equalsIgnoreCase(valorOpcao)) return novedades;
        else if(infantil.toString().equalsIgnoreCase(valorOpcao)) return infantil;
        else if(cocina.toString().equalsIgnoreCase(valorOpcao)) return cocina;
        else return  null;
    }
   
}
