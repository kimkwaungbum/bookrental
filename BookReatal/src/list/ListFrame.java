package list;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import detail.DetailFrame;
import list.repo.ListRepo;
import save.SaveFrame;

public class ListFrame extends JFrame {

	JButton b = new JButton("검색");
	JButton b2 = new JButton("도서상세보기");
	JButton b1 = new JButton("검색결과초기화");
	JLabel l = new JLabel("책제목");
	JTextField tf = new JTextField(10);
	JTable t;
	DefaultTableModel tm;
	private String[][] data;



	public ListFrame() {
		setTitle("도서관리시스템 - 일람화면");
		setSize(700, 600);
		setLayout(new BorderLayout(10, 10));

		setNorthPanel();
		setCenterPanel();
		setEastPanel();
		setSouthPanel();

		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		 ListRepo listRepo = new ListRepo();
//	        String[][] data = listRepo.list();

	}
	private void setCenterPanel() {
		JPanel p = new JPanel();
		String[] title = {"책제목", "출판사", "카테고리", "저자", "대여상태"};


		tm = new DefaultTableModel(new String[0][0], title);

		t = new JTable(tm);
		JScrollPane s = new JScrollPane(t);

		p.add(s);
		add(p,"Center");




		b.addActionListener(e->{

			ListRepo listData = new ListRepo();
			String[][] dataList = listData.list();
			tm.setRowCount(0);
			b2.setEnabled(false);

			for(String[] data : dataList) {

				String searchWord = tf.getText();
				if(data[0].contains(searchWord)) {
					tm.addRow(data);
				}

			}
			if (data != null) {
		        tm.setRowCount(0);
		        b2.setEnabled(false);

		        for (String[] rowData : data) {
		            tm.addRow(rowData);
		        }
		    }
		});
		t.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {

				b2.setEnabled(true);
			}
		});

	}
		private void setNorthPanel() {
			JPanel p = new JPanel();

			p.add(l);
			p.add(tf);
			p.add(b);
			add(p, "North");

			b1.addActionListener(e->{
				tf.setText("");
				b2.setEnabled(false);
				tm.setRowCount(0);
			});
		}
		private void setEastPanel() {
			JPanel p = new JPanel(new GridLayout(10, 0));
			JButton b1 = new JButton("도서등록");
			b2.setEnabled(false);
			p.add(b1);
			p.add(b2);
			add(p, "East");

			b1.addActionListener(e-> {
				setVisible(false);
				new SaveFrame();
			});
			b2.addActionListener(e->{
				int selectedRow = t.getSelectedRow();
			    String selectedBookTitle = (String) t.getValueAt(selectedRow, 0);
			    new DetailFrame(selectedBookTitle);


			    setVisible(false);


			});

		}
		private void setSouthPanel() {
			JPanel p = new JPanel();

			p.add(b1);
			add(p, "South");
		}

		public static void main(String[] args) {
			new ListFrame();
		}


	}
