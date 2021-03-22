import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class GeneradorScript {
	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		GeneradorScript gs = new GeneradorScript();
		
		Scanner reader = new Scanner(System.in);
		String disco;
		boolean crearTabla = false;

		String nombreTabla = "";
		int numRegistros = 0;
		int numCampos = 0;
		int camposSeleccionados[], contador[];
		String primeraCondicionCamposSeleccionados[], segundaCondicionCamposSeleccionados[];
		
		char[] alfanumerico = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
				'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y','z' };
		
		char[] alfabeto = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		
		String[] nombres= new String [ ]{"santiago","maikol","luis","gerardo","facundo","pablo","selma","jesus","jaime","felipe",
        		"mauricio","alonso","gabriel","jessica","kevin","piero","enrique","fausto","salome","reyna","jordy","joaquin","hugo",
        		"cristian","manuel","adrian","bruno","mireya","gael","patricia","sofia","angel","juan","pedro","guillermo","homero",
        		"david","tomas","dylan","donald","francisco","julieta","natalia","facundo","karina","jimena","beatriz","josue","cesar",
        		"omar","oliver"};
		
		String[] apellidos= new String [ ]{"garcia","lopez","perez","gonzales","sanchez","sanchez","martinez","rodriguez","fernandez",
				"gomez","martin","panduro","hernandez","ruiz","diaz","alvarez","jimenez","lopez","moreno","garmendia","munoz","alonso",
				"garabito","guevara","sequeda","maldonado","quintero","millan","morales","blanco","guzman","serrano", "molina","huerta",
				"santos","ortega","gil","romero","sanz","gutierrez","dominguez","ramos","castro","cabral","flores","mesa","martinez","vela",
				"zapata","cueva","guerrero"};         
		
		String[] ciudades = new String[] {"cali","popayán","bogotá","pasto","cartagena","bucaramanga","medellin","cucuta","barrancabermeja",
				"cartagena","ibagué","soledad","pereira","santa marta","villavicencio","pereira","manizales","valledupar","buenaventura","neiva"};
		
		String[] tiposCalles = new String[] {"avenida","calle","carrera","diagonal"};
		
		String[] tiposSangre = new String[] {"O+", "O-", "A+", "A-","B+","B-","AB+","AB-"};
		
		String[] dominios = new String[] {"@hotmail.com", "@outlook.com", "@gmail.com", "@yahoo.es"};
		
		System.out.println("¿Desea crear una tabla? Digite Y, o N si solo requiere llenar campos\n");
		String crear = reader.nextLine();
		if(crear.toUpperCase().equals("Y"))
		{
			crearTabla = true;
			System.out.println("Se creara la tabla.");
		}
		else
		{
			System.out.println("No se creara una tabla");
		}

		System.out.println("\n¿Cuál es el nombre de la tabla que quiere llenar?\n");
		nombreTabla = reader.nextLine();

		System.out.println("¿Cuántos registros quiere crear?\n");
		numRegistros = reader.nextInt();

		System.out.println("¿Cuántos campos tiene la tabla?\n");
		numCampos = reader.nextInt();

		camposSeleccionados = new int[numCampos];
		contador = new int[numCampos];
		primeraCondicionCamposSeleccionados = new String[numCampos];
		segundaCondicionCamposSeleccionados = new String[numCampos];

		for (int i = 0; i < numCampos; i++) {
			System.out.println(
					"\nPara el campo " + (i+1) + " ¿qué dato aleatorio quiere poner (0) un código, (1) un nombre, (2) un apellido, (3) una ciudad, "
							+ "(4) una dirección de correo, (5) una dirección de ciudad, (6) un tipo de sangre, (7) un número entero, (8) un número real, (9) una\r\n"
							+ "letra, (10) un texto aleatorio, (11) Una IPv4, (12) Una IPv6, (13) un texto formateado? \n");
			camposSeleccionados[i] = reader.nextInt();
			if(camposSeleccionados[i]==0)
			{
				System.out.println("\n¿A partir de qué número entero inicia?");
				primeraCondicionCamposSeleccionados[i] = String.valueOf(reader.nextInt());
				contador[i]=Integer.parseInt(primeraCondicionCamposSeleccionados[i]);
			}
			else
				if(camposSeleccionados[i]==7)
				{
					System.out.println("\n¿Cual es el valor mínimo?");
					primeraCondicionCamposSeleccionados[i] = String.valueOf(reader.nextInt());
					System.out.println("\n¿Cual es el valor máximo?");
					segundaCondicionCamposSeleccionados[i] = String.valueOf(reader.nextInt());
				}
				else
					if(camposSeleccionados[i]==8)
					{
						System.out.println("\n¿Cual es el valor mínimo? (Ejemplo:10,0)");
						primeraCondicionCamposSeleccionados[i] = String.valueOf(reader.nextDouble());
						System.out.println("¿Cual es el valor máximo? (Ejemplo:100,0)");
						segundaCondicionCamposSeleccionados[i] = String.valueOf(reader.nextDouble());
					}
					else
						if(camposSeleccionados[i]==10)
						{
							System.out.println("\n¿Cuantos caracteres debe tener el texto?");
							primeraCondicionCamposSeleccionados[i] = String.valueOf(reader.nextInt());
						}
						else
							if(camposSeleccionados[i]==13)
							{
								reader.nextLine();
								System.out.println("\n¿Cual es el formato del texto? (Use N para una Letra, 8 para un número y puede usar el caracter - para separar)");
								primeraCondicionCamposSeleccionados[i] = reader.nextLine();
							}
		}
		
		//UBICACION A DEPOSITAR ARCHIVO
		reader.nextLine();
		System.out.println("\nDigite la letra del disco local en el cual desea su archivo sql. Ejemplo: D \n(No retirar disco mientras se ejecuta el programa!)");
		disco = reader.nextLine();
		String ruta = disco.toUpperCase()+":\\"+nombreTabla+".sql";   							
		System.out.println("\nSe creara asi: "+ruta);
		File archivo = new File(ruta);
		BufferedWriter bw;
		try{
			bw = new BufferedWriter(new FileWriter(archivo));
			bw.close();
		}
		catch(Exception evento)
		{
			System.out.println("Error en archivos"+evento.getMessage());
		}
		
		File archiv = new File( ruta );
		
		if(crearTabla)
		{
			String datos = "CREATE TABLE `"+nombreTabla+"` (";
			gs.escribirEnArchivo(archiv, datos);
			 
			//CABECERA
			for (int i=0; i < numCampos; i++)
			{
				if(camposSeleccionados[i]==0)
				{
					gs.escribirEnArchivo(archiv,"`codigo` double NOT NULL,");
				}
				else
					if(camposSeleccionados[i]==1)
					{
						gs.escribirEnArchivo(archiv,"`nombre` varchar(255) DEFAULT NULL,");
					}
					else
						if(camposSeleccionados[i]==2)
						{
							gs.escribirEnArchivo(archiv,"`apellido` varchar(255) DEFAULT NULL,");
						}
						else
							if(camposSeleccionados[i]==3)
							{
								gs.escribirEnArchivo(archiv,"`ciudad` varchar(255) DEFAULT NULL,");
							}
							else
								if(camposSeleccionados[i]==4)
								{
									gs.escribirEnArchivo(archiv,"`correo` varchar(255) DEFAULT NULL,");
								}
								else
									if(camposSeleccionados[i]==5)
									{
										gs.escribirEnArchivo(archiv,"`direccion` varchar(255) DEFAULT NULL,");
									}
									else
										if(camposSeleccionados[i]==6)
										{
											gs.escribirEnArchivo(archiv,"`tipo sangre` varchar(255) DEFAULT NULL,");
										}
										else
											if(camposSeleccionados[i]==7)
											{
												gs.escribirEnArchivo(archiv,"`entero` double DEFAULT NULL,");
											}
											else
												if(camposSeleccionados[i]==8)
												{
													gs.escribirEnArchivo(archivo, "`real` double DEFAULT NULL,");
												}
												else
													if(camposSeleccionados[i]==9)
													{
														gs.escribirEnArchivo(archivo, "`letra` varchar(255) DEFAULT NULL,");
													}
													else
														if(camposSeleccionados[i]==10)
														{
															gs.escribirEnArchivo(archivo, "`texto aleatorio` varchar(255) DEFAULT NULL,");
														}
														else
															if(camposSeleccionados[i]==11)
															{
																gs.escribirEnArchivo(archivo, "`ipv4` varchar(255) DEFAULT NULL,");
															}
															else
																if(camposSeleccionados[i]==12)
																{
																	gs.escribirEnArchivo(archivo, "`ipv6` varchar(255) DEFAULT NULL,");
																}
																else
																	if(camposSeleccionados[i]==13)
																	{
																		gs.escribirEnArchivo(archivo, "`texto formateado` varchar(255) DEFAULT NULL,");
																	}
			}
			gs.escribirEnArchivo(archivo, "PRIMARY KEY (`codigo`)) ENGINE=INNODB DEFAULT CHARSET=utf8;");
		}
		
		gs.escribirEnArchivo(archivo, "INSERT  INTO `"+nombreTabla+"` (");
		
		//DATOS
		System.out.println("Trabajando...");
		for (int i=0; i < numCampos; i++)
		{
			if(camposSeleccionados[i]==0)
			{
				gs.escribirEnArchivo(archiv,"`codigo`");
			}
			else
				if(camposSeleccionados[i]==1)
				{
					gs.escribirEnArchivo(archiv,"`nombre`");
				}
				else
					if(camposSeleccionados[i]==2)
					{
						gs.escribirEnArchivo(archiv,"`apellido`");
					}
					else
						if(camposSeleccionados[i]==3)
						{
							gs.escribirEnArchivo(archiv,"`ciudad`");
						}
						else
							if(camposSeleccionados[i]==4)
							{
								gs.escribirEnArchivo(archiv,"`correo`");
							}
							else
								if(camposSeleccionados[i]==5)
								{
									gs.escribirEnArchivo(archiv,"`direccion`");
								}
								else
									if(camposSeleccionados[i]==6)
									{
										gs.escribirEnArchivo(archiv,"`tipo sangre`");
									}
									else
										if(camposSeleccionados[i]==7)
										{
											gs.escribirEnArchivo(archiv,"`entero`");
										}
										else
											if(camposSeleccionados[i]==8)
											{
												gs.escribirEnArchivo(archivo, "`real`");
											}
											else
												if(camposSeleccionados[i]==9)
												{
													gs.escribirEnArchivo(archivo, "`letra`");
												}
												else
													if(camposSeleccionados[i]==10)
													{
														gs.escribirEnArchivo(archivo, "`texto aleatorio`");
													}
													else
														if(camposSeleccionados[i]==11)
														{
															gs.escribirEnArchivo(archivo, "`ipv4`");
														}
														else
															if(camposSeleccionados[i]==12)
															{
																gs.escribirEnArchivo(archivo, "`ipv6`");
															}
															else
																if(camposSeleccionados[i]==13)
																{
																	gs.escribirEnArchivo(archivo, "`texto formateado`");
																}
			if(i<numCampos-1)
			{
				gs.escribirEnArchivo( archivo, "," );
			}
		}
		
		gs.escribirEnArchivo( archivo, ") VALUES " );
		
		for(int j=0; j< numRegistros; j++)
		{
			gs.escribirEnArchivo( archivo, "(" );
			for (int i=0; i < numCampos; i++)
			{
				if(camposSeleccionados[i]==0)
				{
					gs.escribirEnArchivo(archiv,Integer.toString(contador[i]));
					contador[i]++;
				}
				else
					if(camposSeleccionados[i]==1)
					{
						gs.escribirEnArchivo(archiv,"'"+gs.unNombre(nombres)+"'");
					}
					else
						if(camposSeleccionados[i]==2)
						{
							gs.escribirEnArchivo(archiv,"'"+gs.unApellido(apellidos)+"'");
						}
						else
							if(camposSeleccionados[i]==3)
							{
								gs.escribirEnArchivo(archiv,"'"+gs.unaCiudad(ciudades)+"'");
							}
							else
								if(camposSeleccionados[i]==4)
								{
									gs.escribirEnArchivo(archiv,"'"+gs.unCorreo(alfanumerico, dominios)+"'");
								}
								else
									if(camposSeleccionados[i]==5)
									{
										gs.escribirEnArchivo(archiv,"'"+gs.unaDireccion(tiposCalles)+"'");
									}
									else
										if(camposSeleccionados[i]==6)
										{
											gs.escribirEnArchivo(archiv,"'"+gs.unTipoSangre(tiposSangre)+"'");
										}
										else
											if(camposSeleccionados[i]==7)
											{
												gs.escribirEnArchivo( archiv,Integer.toString( gs.unEntero(Integer.parseInt(primeraCondicionCamposSeleccionados[i]), Integer.parseInt(segundaCondicionCamposSeleccionados[i])) ) );
											}
											else
												if(camposSeleccionados[i]==8)
												{
													gs.escribirEnArchivo(archivo,Double.toString(gs.unNumReal(Double.parseDouble(primeraCondicionCamposSeleccionados[i]), Double.parseDouble(segundaCondicionCamposSeleccionados[i]))));
												}
												else
													if(camposSeleccionados[i]==9)
													{
														gs.escribirEnArchivo(archivo, "'"+gs.unaLetra(alfabeto)+"'");
													}
													else
														if(camposSeleccionados[i]==10)
														{
															gs.escribirEnArchivo(archivo, "'"+gs.unTextoAleatorio(Integer.parseInt(primeraCondicionCamposSeleccionados[i]), alfabeto)+"'");
														}
														else
															if(camposSeleccionados[i]==11)
															{
																gs.escribirEnArchivo(archivo, "'"+gs.unaIPv4()+"'");
															}
															else
																if(camposSeleccionados[i]==12)
																{
																	gs.escribirEnArchivo(archivo, "'"+gs.unaIPv6(alfanumerico)+"'");
																}
																else
																	if(camposSeleccionados[i]==13)
																	{
																		gs.escribirEnArchivo(archivo, "'"+gs.unTextoFormateado(primeraCondicionCamposSeleccionados[i], alfabeto)+"'");
																	}
				if(i<numCampos-1)
				{
					gs.escribirEnArchivo( archivo, "," );
				}
			}
			gs.escribirEnArchivo( archivo, ")" );
			if(j<numRegistros-1)
			{
				gs.escribirEnArchivo( archivo, "," );
			}
		}
		gs.escribirEnArchivo(archivo, ";");
		System.out.println("\nArchivo creado! Programa terminado.");
	}
	
	public void escribirEnArchivo2(File archivo, String linea)
    {
		System.out.print(linea);
	}
	
	public void escribirEnArchivo(File archivo, String linea)
    {
		try
		{			
			FileWriter TextOut = new FileWriter(archivo, true);
			TextOut.write(linea);
			TextOut.close();
		} 
		catch (IOException e) {
			System.out.println("Error en escritura de archivo");
		}
	}
	
	public String unNombre( String[] nombres )
	{
		Random azar = new Random();
		return nombres[azar.nextInt(49)];
	}
	
	public String unApellido( String[] apellidos )
	{
		Random azar = new Random();
		return apellidos[azar.nextInt(49)];
	}
	
	public String unaCiudad( String[] ciudades )
	{
		Random azar = new Random();
		return ciudades[azar.nextInt(19)];
	}
	
	public String unCorreo(char[] alfanumericos, String[] dominios) {
		Random azar = new Random();
		String correo = "";

		for (int i = 0; i < 8; i++) {
			correo += alfanumericos[azar.nextInt(36)];
		}		
		correo +=dominios[azar.nextInt(3)];

		return correo;
	}
	
	public String unaDireccion(String[] tipoCalle)
	{
		Random azar = new Random();
		String direccion = "";
		
		direccion = tipoCalle[azar.nextInt(3)] + " ";
		direccion += unEntero(1, 150);
		direccion += " # ";
		direccion += unEntero(1, 150) + "-" + unEntero(1, 150);
		return direccion;
	}
	
	public String unTipoSangre(String[] tiposSangre)
	{
		Random azar = new Random();
		String tipoSangre = "";
		
		tipoSangre = tiposSangre[azar.nextInt(7)];
		return tipoSangre;
	}
	
	public int unEntero(int minimo, int maximo)
	{
		Random azar = new Random();
		int num = 0;
		num = azar.nextInt(maximo);
		while(num < minimo || num > maximo)
		{
			num = azar.nextInt(maximo);
		}
		return num;
	}
	
	public double unNumReal(double minimo, double maximo)
	{
		Random azar = new Random();
		double num = 0.0;
		while(num < minimo || num > maximo)
		{
			num = (double)(azar.nextDouble())*( (double)(azar.nextInt( (int)maximo )) );
		}
		return num;
	}
	
	public char unaLetra(char[] alfabeto)
	{
		Random azar = new Random();
		char letra;
		letra = alfabeto[azar.nextInt(26)];
		return letra;
	}
	
	public String unTextoAleatorio(int tamano,char[] alfabeto)
	{
		Random azar = new Random();
		String texto = "";
		
		for (int i = 0; i < tamano; i++) {
			texto += alfabeto[azar.nextInt(26)];
		}
		return texto;
	}
	
	public String unaIPv4()
	{
		Random azar = new Random();
		String ip = "";
		ip += azar.nextInt(256);
		for(int i =0; i<3; i++)
		{
			ip += "." + azar.nextInt(256);
		}
		return ip;
	}
	
	public String unaIPv6(char[] alfanumerico)
	{
		Random azar = new Random();
		String ip = "";
		ip += alfanumerico[azar.nextInt(16)] + alfanumerico[azar.nextInt(16)] + alfanumerico[azar.nextInt(16)];
		for(int i =0; i<7; i++)
		{
			ip += ":" + alfanumerico[azar.nextInt(16)] + alfanumerico[azar.nextInt(16)] + alfanumerico[azar.nextInt(16)];
		}
		return ip.toUpperCase();
	}
	
	public String unTextoFormateado(String formato, char[] alfabeto)
	{
		Random azar = new Random();
		String texto = "";
		for( int i=0; i<formato.length(); i++)
		{
			if(formato.charAt(i)=='N')
			{
				texto += alfabeto[azar.nextInt(26)];
			}
			else
				if(formato.charAt(i)=='8')
				{
					texto += azar.nextInt(10);
				}
				else
					if(formato.charAt(i)=='-')
					{
						texto += '-';
					}
		}
		return texto;
	}
}
