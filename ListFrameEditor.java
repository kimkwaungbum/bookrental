package list;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ListFrameEditor extends JFrame {

	JButton b2 = new JButton("도서상세보기");
	JTable table;
	JTextField searchTextField;
	ListDataEditor listData = new ListDataEditor();

	public ListFrameEditor() {
		setTitle("도서관리시스템 - 일람화면");
		setSize(700,600);
		setLayout(new BorderLayout(10, 10));

		setNorthPanel();
		setCenterPanel();
		setEastPanel();
		setSouthPanel();

		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void setCenterPanel() {
		    JPanel panel = new JPanel();

		    String[] list = {"책 ","출판사","카테고리","저자","대여상태"};
		    String [][] data = listData.loadData();
		    DefaultTableModel model = new DefaultTableModel(data, list);
		    table = new JTable(model);
		    JScrollPane sp = new JScrollPane(table);
		    panel.add(sp);
		    add(panel, "Center");

		    table.addMouseListener(new MouseAdapter() {
		        public void mouseClicked(MouseEvent e) {
		            b2.setEnabled(true);
		        }
		    });
	}



	private void setNorthPanel() {
		JPanel p = new JPanel();
		JLabel l = new JLabel("책제목");
		searchTextField = new JTextField(10);
		JButton b = new JButton("검색");
		b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBooks();
            }
        });
		p.add(l);
		p.add(searchTextField);
		p.add(b);
		add(p, "North");
	}

	private void setEastPanel() {
		JPanel p = new JPanel(new GridLayout(10,0));

		JButton b1 = new JButton("도서등록");
		b2.setEnabled(false);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showBookDetails();
            }
        });
		p.add(b1);
		p.add(b2);
		add(p, "East");
	}

	private void setSouthPanel() {
		JPanel p = new JPanel();
		JButton b1 = new JButton("검색결과초기화");
		 b1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                resetSearchResults();
	            }
	        });
		p.add(b1);
		add(p, "South");
	}
	private void searchBooks() {
        String searchTerm = searchTextField.getText().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);


        String[][] allBooks = listData.loadData();

        for (String[] book : allBooks) {

            if (book[0].toLowerCase().contains(searchTerm)) {
                model.addRow(book);
            }
        }
	}

    private void showBookDetails() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String bookInfo = "책: " + table.getValueAt(selectedRow, 0) + "\n"
                    + "출판사: " + table.getValueAt(selectedRow, 1) + "\n"
                    + "카테고리: " + table.getValueAt(selectedRow, 2) + "\n"
                    + "저자: " + table.getValueAt(selectedRow, 3) + "\n"
                    + "대여상태: " + table.getValueAt(selectedRow, 4);

            JOptionPane.showMessageDialog(this, bookInfo, "도서 상세 정보", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void resetSearchResults() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);


        String[][] allBooks = listData.loadData();

        for (String[] book : allBooks) {
            model.addRow(book);
        }

        searchTextField.setText("");
    }

    private void bookTableMouseClicked(MouseEvent evt) {
        b2.setEnabled(true);
    }

	public static void main(String[] args) {
		new ListFrameEditor();
	}


}
