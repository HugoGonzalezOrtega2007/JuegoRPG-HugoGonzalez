import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        //BUCLE INICIO DEL JUEGO
        boolean inicioJuego = true;
        while (inicioJuego) {

            //LISTAS INICIALES (SE MANTIENEN IGUALES)
            String[] enemigos = {"Ogro", "Goblin", "Mago oscuro", "Slime"};
            String[] recompensas = {"Poción de vida", "Poción magica", "Poción de daño", "Poción de daño extremo"};
            String[] inventario = new String[10];
            String[] interaccion = {"normal", "normal", "normal", "esquivo", "crítico"};

            //VARIABLES INICIALES (REINICIAN AQUÍ)
            String nombre = "";
            int puntosSalud = 100;
            int puntosMagia = 50;
            double multDaño = 1.0;
            int dañoFis = 15;
            int dañoMag = 35;
            int oro = 0;
            int pocionVida = 0;
            int pocionMagica = 0;
            int pocionDaño = 0;
            int pocionDañoExtremo = 0;

            //ATAQUES (RECALCULADOS CADA PARTIDA)
            double dañoAtaqueNormalUsuario = dañoFis * multDaño;
            double dañoAtaqueCriticoUsuario = dañoAtaqueNormalUsuario * 1.5;
            double dañoAtaqueMagico = dañoMag * multDaño;
            double dañoAtaqueNormalEnemigo = 0;
            double dañoAtaqueCriticoEnemigo = dañoAtaqueNormalEnemigo * 2;

            //BUCLE - PANTALLA DE MODIFICACION
            boolean modificacion = true;
            while (modificacion) {

                System.out.println("== PERSONALIZACIÓN DEL PERSONAJE ==");
                System.out.print("¿Como quieres que se llame tu personaje? ");
                nombre = sc.next();
                System.out.print("¿Que clase quieres que tenga tu personaje? ( 1.Mago | 2.Guerrero | 3.Druida | 4.Elfo ) ");
                int clase = sc.nextInt();
                if (clase != 1 && clase != 2 && clase != 3 && clase != 4) {
                    System.out.println("Opción no disponible");
                }
                sc.nextLine();

                System.out.print("Quieres modificar algo antes de empezar? (Si/No) ");
                String modificacionRespuesta = sc.next();
                sc.nextLine();
                if (modificacionRespuesta.equalsIgnoreCase("Si")) {
                    continue;
                } else if (modificacionRespuesta.equalsIgnoreCase("No")) {
                    modificacion = false;
                } else {
                    System.out.println("Opción no valida.");
                    continue;
                }
            }

            //INICIO JUEGO
            System.out.println("\n== INICIO DEL JUEGO ==");

            boolean seguirJuego = true;
            while (seguirJuego) {

                int index = rand.nextInt(enemigos.length);
                String enemigoRandom = enemigos[index];
                System.out.println("Mientras caminabas por el bosque un " + enemigoRandom + " se cruzó ante ti");

                double vidaEnemigo = rand.nextInt(100 - 40 + 1) + 40;

                System.out.println("\n== ⚔️ INICIO DEL COMBATE ⚔️ ==");

                while (true) {
                    System.out.println("Usuario: " + nombre + " | Estadísticas: Puntos de salud🔋: " + puntosSalud + " | Puntos de magia🪄: " + puntosMagia +
                            " | Multiplicador daño 👊✖️: " + multDaño + " | Daño físico👊: " + dañoFis + " | Daño magico👊🪄: " + dañoMag +
                            " | Oro🪙: " + oro);
                    System.out.println("Enemigo: " + enemigoRandom + " | Vida: " + vidaEnemigo);
                    System.out.print("\n¿Que acción deseas realizar? ( 1. Atacar | 2. Ataque mágico | 3. Objetos | 4. Rendirse ) ");
                    int opcion = sc.nextInt();

                    int indice = rand.nextInt(interaccion.length);
                    String ataque = interaccion[indice];

                    //ATAQUE NORMAL USUARIO
                    if (opcion == 1) {

                        if (ataque.equals("normal")) {
                            System.out.println("Has realizado un ataque normal y has hecho " + dañoAtaqueNormalUsuario + " de daño al " + enemigoRandom);
                            vidaEnemigo -= dañoAtaqueNormalUsuario;

                        } else if (ataque.equals("esquivo")) {
                            System.out.println("El " + enemigoRandom + " ha esquivado el ataque");

                        } else {
                            System.out.println("Has realizado un ataque crítico y has hecho " + dañoAtaqueCriticoUsuario + " de daño al " + enemigoRandom);
                            vidaEnemigo -= dañoAtaqueCriticoUsuario;
                        }

                        //COMPROVACION MUERTE ENEMIGO --ATAQUE NORMAL-- + RECOMPENSAS
                        if (vidaEnemigo <= 0) {
                            System.out.println("\n== 🎉 HAS GANADO EL COMBATE 🎉 ==");

                            //RECOMPENSAS
                            int indes = rand.nextInt(interaccion.length);
                            String recompensaVictoria = recompensas[index];
                            System.out.println("Has ganado una " + recompensaVictoria + " 🧙‍♂️");
                            if (recompensaVictoria.equals("poción de vida")) {
                                pocionVida += 1;
                            } else if (recompensaVictoria.equals("poción de magia")) {
                                pocionMagica += 1;
                            } else if (recompensaVictoria.equals("poción de daño")) {
                                pocionDaño += 1;
                            } else {
                                pocionDañoExtremo += 1;
                            }

                            //ORO
                            int oroGanado = rand.nextInt(5) + 1;
                            System.out.println("También has ganado " + oroGanado + " de oro 🪙");
                            oro += oroGanado;

                            //VIDA
                            int vidaGanada = rand.nextInt(25) + 25;
                            puntosSalud += vidaGanada;
                            if (puntosSalud > 100) puntosSalud=100;

                            System.out.println("--------------------------------------------------------------");
                            break;
                        }

                        //ATAQUE RIVAL
                        indice = rand.nextInt(interaccion.length);
                        ataque = interaccion[indice];
                        dañoAtaqueNormalEnemigo = rand.nextInt(10) + 10;
                        dañoAtaqueCriticoEnemigo = dañoAtaqueNormalEnemigo * 2;

                        System.out.println("\nTurno del " + enemigoRandom);

                        if (ataque.equals("normal")) {
                            System.out.println("El " + enemigoRandom + " ha realizado un ataque normal y te ha hecho " + dañoAtaqueNormalEnemigo + " de daño");
                            System.out.println("");
                            puntosSalud -= dañoAtaqueNormalEnemigo;

                        } else if (ataque.equals("esquivo")) {
                            System.out.println("Has esquivado el ataque del " + enemigoRandom);
                            System.out.println("");

                        } else {
                            System.out.println("El " + enemigoRandom + " ha realizado un ataque crítico y te ha hecho " + dañoAtaqueCriticoEnemigo + " de daño");
                            System.out.println("");
                            puntosSalud -= dañoAtaqueCriticoEnemigo;
                        }

                        //MUERTE DEL USUARIO
                        if (puntosSalud <= 0) {
                            System.out.println("\n== ☠️ HAS PERDIDO EL COMBATE ☠️ ==");
                            System.out.println("--------------------------------------------------------------");

                            System.out.print("¿Quieres iniciar una nueva partida? (Si/No) ");
                            String partidaNueva = sc.next();

                            if (partidaNueva.equalsIgnoreCase("Si")) {
                                seguirJuego = false;
                                break;
                            } else {
                                seguirJuego = false;
                                inicioJuego = false;
                                break;
                            }
                        }
                        puntosMagia += 10;
                        if (puntosMagia>100) puntosMagia=100;

                    //ATAQUE MAGICO
                    } else if (opcion == 2) {

                        if (puntosMagia < 25) {
                            System.out.println("No tienes los suficientes puntos de magia para poder realizar un ataque magico");
                        } else {
                            System.out.println("Has realizado un ataque mágico y has hecho " + dañoAtaqueMagico + " de daño al " + enemigoRandom);
                            puntosMagia -= 25;
                            vidaEnemigo -= dañoAtaqueMagico;
                        }

                        //COMPROVACION MUERTE ENEMIGO --ATAQUE MAGICO-- + RECOMPENSAS
                        if (vidaEnemigo <= 0) {
                            System.out.println("\n== 🎉 HAS GANADO EL COMBATE 🎉 ==");

                            //RECOMPENSAS
                            int indes = rand.nextInt(interaccion.length);
                            String recompensaVictoria = recompensas[index];
                            System.out.println("Has ganado una " + recompensaVictoria + " 🧙‍♂️");
                            if (recompensaVictoria.equals("poción de vida")) {
                                pocionVida += 1;
                            } else if (recompensaVictoria.equals("poción de magia")) {
                                pocionMagica += 1;
                            } else if (recompensaVictoria.equals("poción de daño")) {
                                pocionDaño += 1;
                            } else {
                                pocionDañoExtremo += 1;
                            }

                            //ORO
                            int oroGanado = rand.nextInt(5) + 1;
                            System.out.println("También has ganado " + oroGanado + " de oro 🪙");
                            oro += oroGanado;

                            //VIDA
                            int vidaGanada = rand.nextInt(25) + 25;
                            puntosSalud += vidaGanada;
                            if (puntosSalud>100) puntosSalud=100;

                            //TABERNA
                            System.out.print("Tras un largo combate " + nombre + " ha visto una taberna. ¿Quieres entrar? ");
                            String entrarTaberna = sc.next();
                            if (entrarTaberna.equalsIgnoreCase("Si")) {
                                System.out.println("== 🏪 TABERNA 🏪 ==");
                                int objetosTaberna = rand.nextInt(recompensas.length);
                                int objetosTaberna1 = rand.nextInt(recompensas.length);
                                int objetosTaberna2 = rand.nextInt(recompensas.length);;

                                do { objetosTaberna1 = rand.nextInt(recompensas.length); } while(objetosTaberna1 == objetosTaberna);
                                do { objetosTaberna2 = rand.nextInt(recompensas.length); } while(objetosTaberna2 == objetosTaberna || objetosTaberna2 == objetosTaberna1);

                                int precio1 = rand.nextInt(5) + 5;
                                int precio2 = rand.nextInt(5) + 5;
                                int precio3 = rand.nextInt(5) + 5;

                                System.out.println("Objetos a la venta: " + recompensas[objetosTaberna] + " (" + precio1 + " de oro) | " + recompensas[objetosTaberna1] +
                                        " (" + precio2 + " de oro) | " + recompensas[objetosTaberna2]  + " (" + precio3 + " de oro)" );

                                System.out.print("¿Que poción deseas comprar? ");
                                String compra = sc.next();
                                if (compra.equalsIgnoreCase("Poción de vida")) {
                                    pocionVida+=1;
                                    oro-=6;
                                }
                            }

                            System.out.println("--------------------------------------------------------------");
                            break;
                        }

                        indice = rand.nextInt(interaccion.length);
                        ataque = interaccion[indice];
                        dañoAtaqueNormalEnemigo = rand.nextInt(10) + 10;
                        dañoAtaqueCriticoEnemigo = dañoAtaqueNormalEnemigo * 2;

                        System.out.println("\nTurno del " + enemigoRandom);

                        if (ataque.equals("normal")) {
                            System.out.println("El " + enemigoRandom + " ha realizado un ataque normal y te ha hecho " + dañoAtaqueNormalEnemigo + " de daño");
                            System.out.println("");
                            puntosSalud -= dañoAtaqueNormalEnemigo;

                        } else if (ataque.equals("esquivo")) {
                            System.out.println("Has esquivado el ataque del " + enemigoRandom);
                            System.out.println("");

                        } else {
                            System.out.println("El " + enemigoRandom + " ha realizado un ataque crítico y te ha hecho " + dañoAtaqueCriticoEnemigo + " de daño");
                            System.out.println("");
                            puntosSalud -= dañoAtaqueCriticoEnemigo;
                        }

                        if (puntosSalud <= 0) {
                            System.out.println("\n== ☠️ HAS PERDIDO EL COMBATE ☠️ ==");
                            System.out.println("--------------------------------------------------------------");

                            System.out.print("¿Quieres iniciar una nueva partida? (Si/No) ");
                            String partidaNueva = sc.next();

                            if (partidaNueva.equalsIgnoreCase("Si")) {
                                seguirJuego = false;
                                break;
                            } else {
                                seguirJuego = false;
                                inicioJuego = false;
                                break;
                            }
                        }
                        puntosMagia += 10;
                        if (puntosMagia>100) puntosMagia=100;
                    }

                    //OBJETOS
                    else if (opcion == 3) {
                        System.out.println("== INVENTARIO ==");
                        System.out.println("1. Poción de vida ( " + pocionVida + " ) | 2. Poción Mágica ( " + pocionMagica + " ) | 3. Poción de daño ( " + pocionDaño +
                                " ) | 4. Poción de daño extremo ( " + pocionDañoExtremo + " )");
                        System.out.println("¿Que deseas consumir? ");
                        int consumicion = sc.nextInt();

                        if (consumicion == 1) {
                            if (pocionVida == 0) System.out.println("No tienes pociones de vida ❌\n");
                            else {
                                System.out.println("Te has bebido una pocion de vida. Tus puntos de salud han subido 25 puntos 🔋\n");
                                puntosSalud += 25;
                                pocionVida-=1;
                            }

                        } else if (consumicion == 2) {
                            if (pocionMagica == 0) System.out.println("No tienes pociones magicas ❌\n");
                            else {
                                System.out.println("Te has bebido una pocion magica. Tus puntos mágicos han subido 25 puntos 🪄\n");
                                puntosMagia += 25;
                                pocionMagica-=1;
                            }

                        } else if (consumicion == 3) {
                            if (pocionDaño == 0) System.out.println("No tienes pociones de daño ❌\n");
                            else {
                                System.out.println("Te has bebido una pocion de daño. Tus puntos de daño físico han subido 5 puntos 👊\n");
                                dañoFis += 5;
                                pocionDaño-=1;
                            }

                        } else if (consumicion == 4) {
                            if (pocionDañoExtremo == 0) System.out.println("No tienes pociones de daño extremo ❌\n");
                            else {
                                System.out.println("Te has bebido una pocion de daño extremo. Tus puntos del multiplicador de daño han subido 0.05 puntos 👊✖️\n");
                                multDaño += 0.05;
                                pocionDañoExtremo-=1;
                            }
                        }
                    }

                    //RENDIRSE
                    else if (opcion == 4) {
                        System.out.println("Te has rendido");
                        oro -= 5;
                        break;
                    }
                }
            }
        }
    }
}