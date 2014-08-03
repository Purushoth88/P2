import java.awt.event.ActionListener;


public interface VistaRedSocial {
	public static final String INIT_RED = "INIT_RED";
	public static final String INIT_RED_TOPE = "INIT_RED_TOPE";
	public static final String ASIGNAR_AMIGOS = "ASIGNAR_AMIGOS";
	public static final String TERMINAR = "TERMINAR";
	
	/**
	 * The controller is registered
	 */
	public void controlador(ActionListener ctr);
	
	/**
	 * The file with the data of teams and players is obtained.
	 * @return String with the team file name.
	 */
	public String fichUsuarios();
	
	
	/**
	 * The name of the output file is obtained.
	 * @return String with the output file name.
	 */
	public String fichSalida();
	
	/**
	 * The number of defenders for the Team of the Tournament is obtained.
	 * @return int with the number of defenders.
	 */
	public int numAmigos();
	
		
	/**
	 * The number of forwards for the Team of the Tournament is obtained.
	 * @return int with the number of forwards
	 */
    public int tope();
	
	/**
	 * An error message is shown
	 * @param menssage
	 *            String with the message to show
	 */
	public void error(String mensaje);
	
	/**
	 * An information message is shown.
	 * @param mensaje
	 *            String with the message to show
	 */
	public void ok(String mensaje);
	
	/**
	 * Initialization mode is enabled or disabled
	 * @param b
	 *       true in order to enable init mode; false otherwise
	 */
	public void activarInit(boolean b);
	
	/**
	 * A message is added to the area text
	 * @param mensaje
	 *            String with the message to add
	 */
	public void addLog(String mensaje);
	
	/**
	 * The area text is cleared
	 */
	public void clear();
}
