package Vista;

import Modelo.Entidad.Autor;
import Modelo.Entidad.Libreria;
import Modelo.Entidad.Libro;
import Modelo.Persistencia.DaoAutor;
import Modelo.Persistencia.DaoCreateBBDD;
import Modelo.Persistencia.DaoEditorial;
import Modelo.Persistencia.DaoLibreria;
import Modelo.Persistencia.DaoLibro;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

public class Vista extends javax.swing.JFrame {

    //-------------------------------
    private DaoAutor daoAutor;
    private DaoEditorial daoEditorial;
    private DaoLibreria daoLibreria;
    private DaoLibro daoLibro;
    private DaoCreateBBDD daoCreateBBDD;
    //-------------------------------

    public Vista() {
        //-----------------------------
        daoAutor = new DaoAutor();
        daoEditorial = new DaoEditorial();
        daoLibreria = new DaoLibreria();
        daoLibro = new DaoLibro();
        daoCreateBBDD = new DaoCreateBBDD();
        //----------------------------
        initComponents();
        //---------------------
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/iconoLibros.png")));
        //--------------------------
        setVisible(true);
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        crearBBDD = new javax.swing.JButton();
        limpiarBBDD = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        labelMostrar = new javax.swing.JLabel();
        mostrarLibros_autor_editorial = new javax.swing.JButton();
        label_libros_autores_editoriales = new javax.swing.JLabel();
        mostrarAutores__llibros = new javax.swing.JButton();
        label_autores_libros = new javax.swing.JLabel();
        mostrarLibrerias_libros = new javax.swing.JButton();
        label_librerias_libros = new javax.swing.JLabel();
        mostrarLibros_librerias = new javax.swing.JButton();
        label_libros_librerias = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cajaMostrarTexto = new javax.swing.JTextArea();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1001, 610));
        setMinimumSize(new java.awt.Dimension(1001, 610));
        setName("frame"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(1001, 610));

        Panel.setMaximumSize(new java.awt.Dimension(1001, 610));
        Panel.setMinimumSize(new java.awt.Dimension(1001, 610));
        Panel.setPreferredSize(new java.awt.Dimension(1001, 610));
        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        crearBBDD.setBackground(new java.awt.Color(56, 16, 40));
        crearBBDD.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        crearBBDD.setForeground(new java.awt.Color(187, 51, 0));
        crearBBDD.setText("CREAR BBDD");
        crearBBDD.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(187, 51, 0), 3, true));
        crearBBDD.setContentAreaFilled(false);
        crearBBDD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearBBDD.setFocusPainted(false);
        crearBBDD.setVerifyInputWhenFocusTarget(false);
        crearBBDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearBBDDActionPerformed(evt);
            }
        });
        Panel.add(crearBBDD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 130, 40));

        limpiarBBDD.setBackground(new java.awt.Color(56, 16, 40));
        limpiarBBDD.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        limpiarBBDD.setForeground(new java.awt.Color(187, 51, 0));
        limpiarBBDD.setText("BORRAR BBDD");
        limpiarBBDD.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(187, 51, 0), 3, true));
        limpiarBBDD.setContentAreaFilled(false);
        limpiarBBDD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        limpiarBBDD.setFocusPainted(false);
        limpiarBBDD.setVerifyInputWhenFocusTarget(false);
        limpiarBBDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarBBDDActionPerformed(evt);
            }
        });
        Panel.add(limpiarBBDD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 40));

        exit.setBackground(new java.awt.Color(56, 16, 40));
        exit.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        exit.setForeground(new java.awt.Color(187, 51, 0));
        exit.setText("EXIT");
        exit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(187, 51, 0), 3, true));
        exit.setContentAreaFilled(false);
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.setFocusPainted(false);
        exit.setVerifyInputWhenFocusTarget(false);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        Panel.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 130, 40));

        labelMostrar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        labelMostrar.setForeground(new java.awt.Color(187, 51, 0));
        labelMostrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMostrar.setText("MOSTRAR");
        Panel.add(labelMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 70, 62));

        mostrarLibros_autor_editorial.setBackground(new java.awt.Color(56, 16, 40));
        mostrarLibros_autor_editorial.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        mostrarLibros_autor_editorial.setForeground(new java.awt.Color(187, 51, 0));
        mostrarLibros_autor_editorial.setText("LIBROS");
        mostrarLibros_autor_editorial.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(187, 51, 0), 3, true));
        mostrarLibros_autor_editorial.setContentAreaFilled(false);
        mostrarLibros_autor_editorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mostrarLibros_autor_editorial.setFocusPainted(false);
        mostrarLibros_autor_editorial.setVerifyInputWhenFocusTarget(false);
        mostrarLibros_autor_editorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarLibros_autor_editorialActionPerformed(evt);
            }
        });
        Panel.add(mostrarLibros_autor_editorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, 110, 40));

        label_libros_autores_editoriales.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        label_libros_autores_editoriales.setForeground(new java.awt.Color(187, 51, 0));
        label_libros_autores_editoriales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_libros_autores_editoriales.setText("Autor + Editorial");
        Panel.add(label_libros_autores_editoriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, 110, 30));

        mostrarAutores__llibros.setBackground(new java.awt.Color(56, 16, 40));
        mostrarAutores__llibros.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        mostrarAutores__llibros.setForeground(new java.awt.Color(187, 51, 0));
        mostrarAutores__llibros.setText("AUTORES");
        mostrarAutores__llibros.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(187, 51, 0), 3, true));
        mostrarAutores__llibros.setContentAreaFilled(false);
        mostrarAutores__llibros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mostrarAutores__llibros.setFocusPainted(false);
        mostrarAutores__llibros.setVerifyInputWhenFocusTarget(false);
        mostrarAutores__llibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarAutores__llibrosActionPerformed(evt);
            }
        });
        Panel.add(mostrarAutores__llibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 170, 110, 40));

        label_autores_libros.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        label_autores_libros.setForeground(new java.awt.Color(187, 51, 0));
        label_autores_libros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_autores_libros.setText("Autor + libros");
        Panel.add(label_autores_libros, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, 110, 30));

        mostrarLibrerias_libros.setBackground(new java.awt.Color(56, 16, 40));
        mostrarLibrerias_libros.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        mostrarLibrerias_libros.setForeground(new java.awt.Color(187, 51, 0));
        mostrarLibrerias_libros.setText("LIBRERÍAS");
        mostrarLibrerias_libros.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(187, 51, 0), 3, true));
        mostrarLibrerias_libros.setContentAreaFilled(false);
        mostrarLibrerias_libros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mostrarLibrerias_libros.setFocusPainted(false);
        mostrarLibrerias_libros.setVerifyInputWhenFocusTarget(false);
        mostrarLibrerias_libros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarLibrerias_librosActionPerformed(evt);
            }
        });
        Panel.add(mostrarLibrerias_libros, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 270, 110, 40));

        label_librerias_libros.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        label_librerias_libros.setForeground(new java.awt.Color(187, 51, 0));
        label_librerias_libros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_librerias_libros.setText("Librerías + Libros");
        Panel.add(label_librerias_libros, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 310, 110, 30));

        mostrarLibros_librerias.setBackground(new java.awt.Color(56, 16, 40));
        mostrarLibros_librerias.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        mostrarLibros_librerias.setForeground(new java.awt.Color(187, 51, 0));
        mostrarLibros_librerias.setText("LIBROS");
        mostrarLibros_librerias.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(187, 51, 0), 3, true));
        mostrarLibros_librerias.setContentAreaFilled(false);
        mostrarLibros_librerias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mostrarLibros_librerias.setFocusPainted(false);
        mostrarLibros_librerias.setVerifyInputWhenFocusTarget(false);
        mostrarLibros_librerias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarLibros_libreriasActionPerformed(evt);
            }
        });
        Panel.add(mostrarLibros_librerias, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 390, 110, 40));

        label_libros_librerias.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        label_libros_librerias.setForeground(new java.awt.Color(187, 51, 0));
        label_libros_librerias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_libros_librerias.setText("Libros + Librerías");
        Panel.add(label_libros_librerias, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 430, 110, 30));

        jScrollPane1.setBorder(null);

        cajaMostrarTexto.setEditable(false);
        cajaMostrarTexto.setBackground(new java.awt.Color(10, 0, 8));
        cajaMostrarTexto.setColumns(1);
        cajaMostrarTexto.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        cajaMostrarTexto.setForeground(new java.awt.Color(187, 51, 0));
        cajaMostrarTexto.setLineWrap(true);
        cajaMostrarTexto.setRows(5);
        cajaMostrarTexto.setText("WelCome to DataLib");
        cajaMostrarTexto.setWrapStyleWord(true);
        cajaMostrarTexto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(201, 66, 8), 3));
        cajaMostrarTexto.setFocusable(false);
        cajaMostrarTexto.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(cajaMostrarTexto);

        Panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 580, 450));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N
        Panel.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void limpiarBBDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarBBDDActionPerformed
        try {
            daoCreateBBDD.limpiarTablas();
            cajaMostrarTexto.setText("BBDD borrada con exito.");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }

    }//GEN-LAST:event_limpiarBBDDActionPerformed

    private void crearBBDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearBBDDActionPerformed
        try {
            daoCreateBBDD.crearBBDD(cajaMostrarTexto);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }

    }//GEN-LAST:event_crearBBDDActionPerformed

    private void mostrarLibros_autor_editorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarLibros_autor_editorialActionPerformed
        try {
            if (daoCreateBBDD.checkNRows() == 0) {
                cajaMostrarTexto.setText("La bbdd esta vacia, debes crearla primero.");
                return;
            }
            System.out.println("Conexion abierta: " + daoLibro.abrirConexion());
            List<Libro> libros = daoLibro.selectAll("Libro");
            cajaMostrarTexto.setText(" --------------------------------------------------LIBROS--------------------------------------------------\n\n");
            for (Libro libro : libros) {
                cajaMostrarTexto.append("-Libro " + libro.getId() + " --> "
                        + "Titulo: " + libro.getTitulo()
                        + " , Autor: " + libro.getAutor().getNombre() + " " + libro.getAutor().getApellidos()
                        + " , Editorial: " + libro.getEditorial().getNombre() + ".\n\n");
            }
            System.out.println("Conexion cerrada: " + daoLibro.cerrarConexion());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());

        }
    }//GEN-LAST:event_mostrarLibros_autor_editorialActionPerformed

    private void mostrarAutores__llibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarAutores__llibrosActionPerformed
        try {
            if (daoCreateBBDD.checkNRows() == 0) {
                cajaMostrarTexto.setText("La bbdd esta vacia, debes crearla primero.");
                return;
            }
            System.out.println("Conexion abierta: " + daoAutor.abrirConexion());
            List<Autor> autores = daoAutor.selectAll("Autor");
            cajaMostrarTexto.setText(" --------------------------------------------------AUTORES--------------------------------------------------\n");
            for (Autor autor : autores) {
                cajaMostrarTexto.append("--------------------------------------------------------------------\n");
                cajaMostrarTexto.append("Autor " + autor.getId() + " : " + autor.getNombre() + " " + autor.getApellidos() + ".\n");
                cajaMostrarTexto.append("--------------------------------------------------------------------\n");
                for (Libro libro : autor.getLibros()) {
                    cajaMostrarTexto.append("-Libro " + libro.getId() + " : "
                            + libro.getTitulo()
                            + " , Precio: " + libro.getPrecio()
                            + " , Editorial: " + libro.getEditorial().getNombre() + ".\n\n");
                }
            }
            System.out.println("Conexion cerrada: " + daoAutor.cerrarConexion());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());

        }
    }//GEN-LAST:event_mostrarAutores__llibrosActionPerformed

    private void mostrarLibrerias_librosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarLibrerias_librosActionPerformed
        try {
            if (daoCreateBBDD.checkNRows() == 0) {
                cajaMostrarTexto.setText("La bbdd esta vacia, debes crearla primero.");
                return;
            }
            System.out.println("Conexion abierta: " + daoLibreria.abrirConexion());
            List<Libreria> librerias = daoLibreria.selectAll("Libreria");
            cajaMostrarTexto.setText(" --------------------------------------------------LIBRERÍAS--------------------------------------------------\n");
            for (Libreria libreria : librerias) {
                cajaMostrarTexto.append("--------------------------------------------------------------------\n");
                cajaMostrarTexto.append("Librería " + libreria.getId() + " : " + libreria.getNombre() + ".\n");
                cajaMostrarTexto.append("--------------------------------------------------------------------\n");
                for (Libro libro : libreria.getLibros()) {
                    cajaMostrarTexto.append("-Libro " + libro.getId() + " : "
                            + libro.getTitulo()
                            + " , Precio: " + libro.getPrecio()
                            + " , Editorial: " + libro.getEditorial().getNombre()
                            + " , Autor: " + libro.getAutor().getNombre() + " " + libro.getAutor().getApellidos()
                            + ".\n\n");
                }
            }
            System.out.println("Conexion cerrada: " + daoLibreria.cerrarConexion());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());

        }
    }//GEN-LAST:event_mostrarLibrerias_librosActionPerformed

    private void mostrarLibros_libreriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarLibros_libreriasActionPerformed
        try {
            if (daoCreateBBDD.checkNRows() == 0) {
                cajaMostrarTexto.setText("La bbdd esta vacia, debes crearla primero.");
                return;
            }
            System.out.println("Conexion abierta: " + daoLibro.abrirConexion());
            List<Libro> libros = daoLibro.selectAll("Libro");
            cajaMostrarTexto.setText(" --------------------------------------------------LIBROS--------------------------------------------------\n\n");
            for (Libro libro : libros) {
                cajaMostrarTexto.append("--------------------------------------------------------------------\n");
                cajaMostrarTexto.append("Libro " + libro.getId() + "\n");
                cajaMostrarTexto.append("--------------------------------------------------------------------\n");
                for (Libreria libreria : libro.getLibrerias()) {
                    cajaMostrarTexto.append("-Libreria " + libreria.getId() + " : "
                            + libreria.getNombre() + ", "
                            + "Direccion: c\\" + libreria.getDireccion().getCalle()
                            + " , (" + libreria.getDireccion().getCiudad() + ")"
                            + " , " + libreria.getDireccion().getPais()
                            + ", cp: " + libreria.getDireccion().getCp()
                            + ". Dueño: " + libreria.getNombre_duenio()+"\n\n"
                    );
                }

            }
            System.out.println("Conexion cerrada: " + daoLibro.cerrarConexion());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());

        }
    }//GEN-LAST:event_mostrarLibros_libreriasActionPerformed

    public static void main(String args[]) {
        try {
            new Vista();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JTextArea cajaMostrarTexto;
    private javax.swing.JButton crearBBDD;
    private javax.swing.JButton exit;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelMostrar;
    private javax.swing.JLabel label_autores_libros;
    private javax.swing.JLabel label_librerias_libros;
    private javax.swing.JLabel label_libros_autores_editoriales;
    private javax.swing.JLabel label_libros_librerias;
    private javax.swing.JButton limpiarBBDD;
    private javax.swing.JButton mostrarAutores__llibros;
    private javax.swing.JButton mostrarLibrerias_libros;
    private javax.swing.JButton mostrarLibros_autor_editorial;
    private javax.swing.JButton mostrarLibros_librerias;
    // End of variables declaration//GEN-END:variables
}
