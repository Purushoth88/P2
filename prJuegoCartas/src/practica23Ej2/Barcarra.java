package practica23Ej2;

public class Barcarra {
	public static void main(String[] args) {
		//Se crean el mazo, el jugador y la banca
		Mazo mazo = new Mazo();
		ManoBacarra jugador = new ManoBacarra();
		ManoBacarra banca = new ManoBacarra();
		
		//Se reparten las cartas iniciales: una al jugador y una a la banca
		jugador.agnadeCarta(mazo.daCarta());
		jugador.agnadeCarta(mazo.daCarta());
		banca.agnadeCarta(mazo.daCarta());
		banca.agnadeCarta(mazo.daCarta());
		
		if(jugador.esNatural()==true && banca.esNatural()==false){
			System.out.println("Gana el jugador con"+jugador+" ("+jugador.cuentaPuntos()+" puntos) frente a "+ banca+" ("+banca.cuentaPuntos()+" puntos) de la banca");
		}
		
		else if(banca.esNatural()==true && jugador.esNatural()==false){
			System.out.println("Gana la banca con "+banca+" ("+ banca.cuentaPuntos()+" puntos) frente a "+ jugador+" ("+jugador.cuentaPuntos()+" puntos) del jugador");
		}
		
		else if(banca.esNatural()==true && jugador.esNatural()==true){
			System.out.println("Empate: Jugador "+ jugador+" ("+jugador.cuentaPuntos()+" puntos) y banca "+ banca +" ("+banca.cuentaPuntos()+" puntos) se han pasado");
		}
		
		else{
			
			if(jugador.cuentaPuntos()<=5){
				System.out.println("El jugador pide una carta extra");
				Carta c=mazo.daCarta();
				jugador.agnadeCarta(c);
			}
			
			if(jugador.cuentaPuntos()<=9 && banca.cuentaPuntos()<7.5 && banca.cuentaPuntos()<jugador.cuentaPuntos()){
				System.out.println("La banca pide una carta extra");
				banca.agnadeCarta(mazo.daCarta());
			}
			
			double puntosJ = jugador.cuentaPuntos();
			double puntosB = banca.cuentaPuntos();
			
			if(puntosJ<=9 && (puntosB>9 || puntosJ>puntosB)){
				System.out.println("Gana el jugador con "+jugador+" ("+ puntosJ+" puntos) frente a "+ banca+" ("+puntosB+" puntos) de la banca");
			}else if (puntosB<=9 && (puntosJ>9 || puntosJ<puntosB)){
				System.out.println("Gana la banca con "+banca+" ("+ puntosB+" puntos) frente a "+ jugador+" ("+puntosJ+" puntos) del jugador");
			}else if(puntosB==puntosJ){
				System.out.println("Empate: Jugador "+ jugador+" ("+puntosJ+" puntos) y banca "+ banca +" ("+puntosB+" puntos) se han pasado");
			}
			
			
		}
		
	}
	
}
