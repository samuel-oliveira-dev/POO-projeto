/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package telas;

import regraNegocio.Livro;
import escritaLeitura.EscritaLeituraLivro;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samuk
 */
public class TelaConsultaLivros extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaConsulta
     */
    public TelaConsultaLivros() {
        initComponents();
        
    }
    
    public void consultar(){
        EscritaLeituraLivro ell = new EscritaLeituraLivro();
        Livro lv = new Livro();
        ArrayList<Livro> populacao = ell.buscar(jComboBoxTipo.getSelectedItem().toString(),jTextFieldArgumento.getText());
        
        
        
        
        DefaultTableModel dtm =  (DefaultTableModel) jTableLivros.getModel();
            
            ArrayList<Livro> lista = ell.ler(ell.PATH);
            
            if(jComboBoxTipo.getSelectedItem().toString().equals("Todos")){
                for(Livro l : lista){
                
                dtm.addRow(
                    new Object[]{
                        l.getTitulo(),
                        l.getAutor(),
                        l.getEditora(),
                        l.getCategoria(),
                        l.getIsbn(),
                        l.getEdicao(),
                        l.getPaginas(),
                        l.getAno(),
                        l.getPreco(),
                        l.getQuantidade(),
                        l.getCodigo(),
                        l.getCategoria()

                    }
            );
            
            
        }
            } else {
              
                for(Livro l : populacao){
                
                dtm.addRow(
                    new Object[]{
                        l.getTitulo(),
                        l.getAutor(),
                        l.getEditora(),
                        l.getCategoria(),
                        l.getIsbn(),
                        l.getEdicao(),
                        l.getPaginas(),
                        l.getAno(),
                        l.getPreco(),
                        l.getQuantidade(),
                        l.getCodigo(),
                        
                        
                        
                        
                        
                    }
            );
            
            
        }
            }
    }
    
    public void popularTabela(ArrayList<Livro> list){
        DefaultTableModel dtm = (DefaultTableModel)jTableLivros.getModel();
        for(Livro l:list){
            dtm.addRow(
                    new Object[]{
                        l.getTitulo(),
                        l.getAutor(),
                        l.getEditora(),
                        l.getCategoria(),
                        l.getIsbn(),
                        l.getEdicao(),
                        l.getPaginas(),
                        l.getAno(),
                        l.getPreco(),
                        l.getQuantidade(),
                        l.getCodigo(),
                    }
            
            
            );
        }
    }
    
    public void limpar(){
        //jTableLivros.setModel(new DefaultTableModel(null, new String[]{"Titulo", "Autor", "Editora", "ISBN", "Edicao", "Paginas", "Ano", "Preco", "Quantidade", "Codigo", "Categoria"}));
        DefaultTableModel dtm =  (DefaultTableModel) jTableLivros.getModel();
        dtm.getDataVector().removeAllElements();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldArgumento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLivros = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();

        jMenuItem1.setText("Abrir em Tela de Venda");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Excluir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Consulta de Produtos");

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Titulo", "Autor", "Codigo", "ISBN", "Listar Excluidos" }));
        jComboBoxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoActionPerformed(evt);
            }
        });

        jLabel1.setText("Consulta por: ");

        jTextFieldArgumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldArgumentoActionPerformed(evt);
            }
        });
        jTextFieldArgumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldArgumentoKeyPressed(evt);
            }
        });

        jTableLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Autor", "Editora", "Genero", "ISBN", "Edicao", "Paginas", "Ano", "Preco", "Quantidade", "Codigo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLivros.getTableHeader().setReorderingAllowed(false);
        jTableLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableLivrosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLivros);
        if (jTableLivros.getColumnModel().getColumnCount() > 0) {
            jTableLivros.getColumnModel().getColumn(0).setResizable(false);
            jTableLivros.getColumnModel().getColumn(1).setResizable(false);
            jTableLivros.getColumnModel().getColumn(2).setResizable(false);
            jTableLivros.getColumnModel().getColumn(3).setResizable(false);
            jTableLivros.getColumnModel().getColumn(4).setResizable(false);
            jTableLivros.getColumnModel().getColumn(5).setResizable(false);
            jTableLivros.getColumnModel().getColumn(6).setResizable(false);
            jTableLivros.getColumnModel().getColumn(7).setResizable(false);
            jTableLivros.getColumnModel().getColumn(8).setResizable(false);
            jTableLivros.getColumnModel().getColumn(9).setResizable(false);
            jTableLivros.getColumnModel().getColumn(10).setResizable(false);
        }

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        jToggleButton1.setText("Cancelar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search.png"))); // NOI18N
        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jTextFieldArgumento, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(467, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToggleButton1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldArgumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addGap(19, 19, 19))
        );

        setBounds(30, 10, 1137, 468);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        limpar();
        EscritaLeituraLivro ell = new EscritaLeituraLivro();
        String selectedItem = jComboBoxTipo.getSelectedItem().toString();
        ArrayList<Livro> pop;
        if(selectedItem.equals("Todos")){
            pop = ell.ler(ell.PATH);
            popularTabela(pop);
        } else {
            if(selectedItem.equals("Listar Excluidos")){
                pop = ell.getDeletados();
                popularTabela(pop);
            } else {
                pop = ell.buscar(selectedItem, ell.PATH);
                popularTabela(pop);
            }
        }
        
        
            
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldArgumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldArgumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldArgumentoActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1KeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formKeyPressed

    private void jTextFieldArgumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldArgumentoKeyPressed
        // TODO add your handling code here:
        limpar();
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultar();
        }
    }//GEN-LAST:event_jTextFieldArgumentoKeyPressed

    private void jTableLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLivrosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableLivrosMouseClicked

    private void jTableLivrosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLivrosMouseReleased
        // TODO add your handling code here:
        if(jComboBoxTipo.getSelectedItem().toString().equals("Listar Excluidos") == false){
            int linha = jTableLivros.rowAtPoint(evt.getPoint());
            if(linha >= 0 && linha < jTableLivros.getRowCount()){
                jTableLivros.setRowSelectionInterval(linha, linha);
            } else {
                jTableLivros.clearSelection();
            }
            int linhaIndex = jTableLivros.getSelectedRow();
            if(linhaIndex < 0){
                return ;
            }
            if(evt.isPopupTrigger() && evt.getComponent() instanceof JTable){
                jPopupMenu1.show(jTableLivros, evt.getX(), evt.getY());
        }
        }
        
        
    }//GEN-LAST:event_jTableLivrosMouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        TelaVenda obj = new TelaVenda();
        JDesktopPane desk = getDesktopPane();
        desk.add(obj);
        obj.setVisible(true);
        int linha = jTableLivros.getSelectedRow();
        obj.setJTextCodigo(jTableLivros.getValueAt(linha, 10).toString());
        String resumo = "Titulo: "+jTableLivros.getValueAt(linha,0).toString() +"\nAutor: "+jTableLivros.getValueAt(linha,1).toString()+"\nPreco: "+jTableLivros.getValueAt(linha,8).toString()+"\nQuantidade: "+jTableLivros.getValueAt(linha,9).toString();
        obj.setTextPane(resumo);
        setVisible(false);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        EscritaLeituraLivro ell = new EscritaLeituraLivro();
        int linha = jTableLivros.getSelectedRow();
        String cod = jTableLivros.getValueAt(linha, 10).toString();
        
        ell.deletar(cod);
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLivros;
    private javax.swing.JTextField jTextFieldArgumento;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}

