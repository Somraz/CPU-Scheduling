/*Name: Tanisha Saxena
  Roll no.-1710110356
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; 
import javax.swing.border.*;
class cpuscheduling extends JFrame implements ActionListener{
     JFrame gantt=new JFrame(); //output screen
    int count,sum; 
     ArrayList<String> ab; //array for processes
     JPanel op11=new JPanel(); 
     JPanel op12=new JPanel();
     JPanel op13=new JPanel();
     JPanel op14=new JPanel();
     JPanel op15=new JPanel();
     JPanel op16=new JPanel();
     JPanel op1=new JPanel(); //panel for chart
     JPanel op2=new JPanel();
     JPanel op3=new JPanel();
     JPanel op4=new JPanel();
     JPanel op5=new JPanel();
     JPanel op6=new JPanel();
     boolean v[]; 
     JTextField t1= new JTextField(20); //to input burst time
    JTextField t2= new JTextField(20);
    JTextField t3= new JTextField(20);
    JTextField t4= new JTextField(20);
    JCheckBox ch =new JCheckBox("FCFS"); //checkbox
    JCheckBox ch1= new JCheckBox("Premptive-SJF");
    JCheckBox ch2 =new JCheckBox("Round Robin");
    JCheckBox ch3= new JCheckBox("Non-Premptive SJF");
    JCheckBox ch4 =new JCheckBox("Premptive Priority");
    JCheckBox ch5= new JCheckBox("Non-Premptive Priority");
    JLabel lb= new JLabel("No. of processes are:  ");
    JLabel lb1=new JLabel("Burst Time :");
    JLabel lb2=new JLabel("Arrival Time :");
    JLabel lb3=new JLabel("Priority :");
    JLabel l4=new JLabel("Time Quantum :");
    String s[]={"P1        ","P2  ","P3  ","P4  ","P5  ","P6  "};
    JComboBox cb=new JComboBox(s);
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JPanel p4=new JPanel();
    JButton comp=new JButton("COMPUTE");
    JPanel o=new JPanel();
    JPanel p=new JPanel();
    JPanel q=new JPanel();
    JPanel x=new JPanel();
    JPanel y=new JPanel();
    JPanel z=new JPanel();
    String at; //to store arrival time
    String bt; //to store burst time
    String pri; //priorities 
    String tq; //time quantum
    String[]bt1;
    String[]at1;
    String[]pri1;
    Border bor = BorderFactory.createLineBorder(Color.black, 2);
    Font f=new Font("Arial",0,25);
    Font f1=new Font("Arial",1,22);
    Font f2=new Font("Arial",1,19); //font style
    Font f3=new Font("Arial",1,15);
    Font f4=new Font("Arial",2,15);
    JLabel ind=new JLabel("*(Lower number indicates higher priority)");
    JPanel pex=new JPanel();
cpuscheduling()
{
       setSize(700,750); //size of input screen
     Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
      setResizable(false);
        setTitle("Assignment Gantt Chart"); //title
        setLocationRelativeTo(null);
        lb.setFont(f);
        lb1.setFont(f);
        lb2.setFont(f);
        lb3.setFont(f);
        l4.setFont(f);
        t1.setFont(f);
        t2.setFont(f);
        t3.setFont(f);
        t4.setFont(f);
        p3.add(ch); //adding checkbox
        p3.add(ch1);
        p3.add(ch2);
        p3.add(ch3);
        p3.add(ch4); 
        p3.add(ch5);
        p4.add(comp);
        comp.setFont(f);
        ch.setFont(f1);
        ch1.setFont(f1);
        ch2.setFont(f1);
        ch3.setFont(f1);
        ch4.setFont(f1);
        ch5.setFont(f1);
        p3.setLayout(new GridLayout(3,2));
        p2.add(lb);
        p2.add(cb);
        add(p2);
        add(p1);
        add(p3);
        add(p4);
        p1.setLayout(new GridLayout(5,2)); //to set layout
        p1.add(lb1);
        p1.add(t1);
        p1.add(lb2);
        p1.add(t2);
        p1.add(lb3);
        p1.add(t3);
        p1.add(ind);
        ind.setFont(f4);
        p1.add(pex);
        p1.add(l4);
        p1.add(t4);
        comp.addActionListener(this);
        setLayout(new GridLayout(4,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
      gantt.setSize(d.width,d.height); //size of output screen
      gantt.setResizable(false);
        gantt.setTitle("OUTPUT SCREEN");
        gantt.setLayout(new GridLayout(6,1));
        gantt.setLocationRelativeTo(null);
       gantt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        gantt.setVisible(false);
      gantt.add(op1); //adding panel to output screen
      op1.setLayout(new GridLayout(2,1));
      op11.setLayout(new GridLayout(3,1));
      op1.add(o);
      op1.add(op11);
        gantt.add(op2);
        op2.setLayout(new GridLayout(2,1));
        op12.setLayout(new GridLayout(3,1));
      op2.add(p);
      op2.add(op12);
        gantt.add(op3);
          op3.setLayout(new GridLayout(2,1));
        op13.setLayout(new GridLayout(3,1));
        op3.add(q);
        op3.add(op13);
        gantt.add(op4);
         op4.setLayout(new GridLayout(2,1));
        op14.setLayout(new GridLayout(3,1));
        op4.add(x);
        op4.add(op14);
        gantt.add(op5);
          op5.setLayout(new GridLayout(2,1));
          op15.setLayout(new GridLayout(3,1));
        op5.add(y);
        op5.add(op15);
        gantt.add(op6);
          op6.setLayout(new GridLayout(2,1));
          op16.setLayout(new GridLayout(3,1));
        op6.add(z);
        op6.add(op16);
}
   @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comp) //compute button pressed
        {
            if(ch.isSelected() || ch1.isSelected()|| ch2.isSelected() || ch3.isSelected()|| ch4.isSelected() || ch5.isSelected()){
            bt=t1.getText(); //extracting burst time
            bt1=bt.split(","); 
            at=t2.getText();           
            at1=at.split(","); 
            pri=t3.getText(); 
            pri1=pri.split(",");
            tq=t4.getText(); //time quantum
        String sel=(String)cb.getSelectedItem(); 
        count =Integer.parseInt(sel.substring(1,2)); //number of processes 
        sum=0; //total burst time
            if((bt1.length!=count) || (at1.length!=count)|| (ch2.isSelected() && (tq.length()==0)) || ((ch4.isSelected() || ch5.isSelected())&& pri1.length!=count))
            JOptionPane.showMessageDialog(null,"Number of entries not correct"); 
            else{
                for(int i=0;i<count;i++)
           {
              sum=sum+Integer.parseInt(bt1[i]);
           }
       
       ab=new ArrayList<String>(count);
       v=new boolean[count];
        for(int i=0;i<count;i++)
        {
          ab.add(bt1[i]+ " "+(i+1)); 
          v[i]=false; 
        }
                createScreen(); //to diplay output screen
            }
             
        }
                    else
        {
            JOptionPane.showMessageDialog(null,"No Box Selected"); 
        }
        }

    }
    public void createScreen()
    {
       gantt.setVisible(true); //to show output screen
       z.removeAll();
       z.setBackground(null);
       z.setBorder(null);
       op16.removeAll();
       y.removeAll();
       y.setBackground(null);
       y.setBorder(null);
       op15.removeAll();
       x.removeAll();
       x.setBackground(null);
       x.setBorder(null);
       op14.removeAll();
        q.removeAll();
        q.setBackground(null);
        q.setBorder(null);
        op13.removeAll();
         p.removeAll();
         p.setBackground(null);
         p.setBorder(null);
        op12.removeAll();
         o.removeAll();
         o.setBackground(null);
         o.setBorder(null);
        op11.removeAll();
        gantt.remove(op1); //removing all panels
        gantt.remove(op2);
        gantt.remove(op3);
        gantt.remove(op4);
        gantt.remove(op5);
        gantt.remove(op6);
          if(ch.isSelected()){
             gantt.add(op1); //adding panel
             FCFS(); //to get FCFS gantt chart
             
          }
         if(ch1.isSelected()){
             gantt.add(op2);
            PreSJF(); //for preempitve SJF
         }           
         if(ch2.isSelected()){
             gantt.add(op3);
             Round(); //for Round Robin
         }
         if(ch3.isSelected()){
             gantt.add(op4);
            NonSJF(); //for non-preemptive SJF
         }
         if(ch4.isSelected()){
             gantt.add(op5);
             PrePri(); //for preemptive priority
         }
         if(ch5.isSelected()){
             gantt.add(op6);
             NonPri(); //for non-preemptive priority
         }
    }
    public void NonPri()
    {
        JLabel jl=new JLabel("Non-Preemptive Priority");
        jl.setFont(f2); //setting font
        z.removeAll(); //removing previous gantt chart
        op16.removeAll();
        z.setLayout(null);
        z.setBackground(Color.white);
       op16.add(jl);
       z.setBorder(bor); //adding border
    String g="",seq="",g1="";
    String wt1="",tat1=""; //for calculatig times
    double tats=0,wts=0;
    int tat[]=new int[count]; //for turn around time
    int wt[]=new int[count]; //for wait time
    int val,val1,sa=0,time=0;
    Arrays.fill(v,false);
    ArrayList<String> ar=new ArrayList<String>(Arrays.asList(at1));
    ArrayList<String> pr=new ArrayList<String>(Arrays.asList(pri1));
                     for(int i=0;i<ar.size();i++)
        {
            ar.set(i,ar.get(i)+" "+(i+1)); //ArrayList of Arrival time
            pr.set(i,pr.get(i)+" "+(i+1)+" "+Integer.parseInt((ab.get(i)).substring(0,(ab.get(i)).indexOf(" "))));  
        }
                      Collections.sort(ar,new Sortby()); 
                      Collections.sort(pr,new Sortby());
      ArrayList<JPanel> temp=new ArrayList<JPanel>();
        JLabel []prlb=new JLabel[count]; //label for process name
      JLabel l[]=new JLabel[count+1];
        for(int i=0;i<count;i++)
            temp.add(new JPanel());
        String mi=(String)Collections.min(ar);
        int min=Integer.parseInt(mi.substring(0,mi.indexOf(' ')));
        time=min;    //setting minimum arrival time
        int i,flag=0;
                while(time!=(sum+min))
        {
           for( i=0;i<count;i++)
             {
                 g=pr.get(i); //getting lowest priority
       for(int j=0;j<ar.size();j++)
            {
                g1=ar.get(j);
                if(Integer.parseInt(g.substring(g.indexOf(" ")+1,g.lastIndexOf(" ")))==Integer.parseInt(g1.substring(g1.indexOf(' ')+1,g1.length())) && v[j]==false && Integer.parseInt(g1.substring(0,g1.indexOf(' ')))<=time)
                {
                    v[j]=true; //setting it as visited
                    flag=1;
                    break;
                }
                
            }  
                 if(flag==1)
                    break;
             }
           flag=0;
        val1=Integer.parseInt(g.substring(g.lastIndexOf(" ")+1,g.length()));
             val=Integer.parseInt(g.substring(g.indexOf(" ")+1,g.lastIndexOf(" "))); 
            z.add(temp.get(i));
            (temp.get(i)).setBorder(bor);
            (temp.get(i)).setBounds((z.getWidth()*(sa+val1))/sum,0,3,(z.getHeight()*3)/4); //making divisions in chart
            prlb[i]=new JLabel("P"+val); //Label for process name
      z.add(prlb[i]);
      prlb[i].setBounds(2+z.getWidth()*(sa+val1/2)/sum,20,25,25);
      l[i]=new JLabel(Integer.toString(sa+Integer.parseInt((ar.get(0)).substring(0,(ar.get(0)).indexOf(' ')))));
      z.add(l[i]); //to print timeline
      l[i].setBounds((z.getWidth()*sa)/sum,(z.getHeight()*3)/4,42,20);
            sa=sa+val1; //adding burst time
      tat[val-1]=sa+Integer.parseInt((ar.get(0)).substring(0,(ar.get(0)).indexOf(' ')))-Integer.parseInt(at1[val-1]);
       wt[val-1]=tat[val-1]-Integer.parseInt(bt1[val-1]);
        time=time+val1; //incrementing time
        
        }
                 JPanel newTemp=new JPanel();
        z.add(newTemp);
      newTemp.setBounds(0,(x.getHeight()*3)/4,x.getWidth(),2); 
      newTemp.setBorder(bor);
             l[count]=new JLabel(Integer.toString(sa+Integer.parseInt((ar.get(0)).substring(0,(ar.get(0)).indexOf(' ')))));
             z.add(l[count]);
              l[count].setBounds(z.getWidth()-19,(z.getHeight()*3)/4,42,20);  
      for(int s=0;s<count;s++)
                {
                    wt1=wt1+"P"+(s+1)+" = "+wt[s]+"     ";
                    tat1=tat1+"P"+(s+1)+" = "+tat[s]+"     ";
                    wts=wts+wt[s]; //total wait time 
                    tats=tats+tat[s]; 
                }
      double avgt=tats/count; //average turn around time
      double avgw=wts/count; //average waiting time
      JLabel w=new JLabel("Wait time: "+wt1+"     "+"Average waiting time: "+avgw);
      w.setFont(f3);
      JLabel ta=new JLabel("Turn Around time: "+tat1+"     "+"Average turn around time: "+avgt);
      ta.setFont(f3);
                op16.add(w);
                op16.add(ta);
        
    }
    public void PrePri()
    {
        JLabel jl=new JLabel("Preemptive Priority");
        jl.setFont(f2); //setting font
    y.removeAll();
    op15.removeAll();
    y.setLayout(null);
    y.setBackground(Color.white);
    op15.add(jl);
    y.setBorder(bor); //setting border
     String g,seq="";
     String tat1="",wt1="";
     double tats=0,wts=0;
    Arrays.fill(v,false);
    ArrayList<String> arr=new ArrayList<String>();
    ArrayList<String> arp=new ArrayList<String>();
    ArrayList<String> ar=new ArrayList<String>(Arrays.asList(at1));
    ArrayList<String> pr=new ArrayList<String>(Arrays.asList(pri1));
        int val1,val,sa,time; //declaring variables
        ArrayList<JPanel> temp=new ArrayList<JPanel>();
        JLabel []prlb1; 
        for(int i=0;i<count*200;i++)
            temp.add(new JPanel());
        int min=Integer.parseInt((String)Collections.min(ar));
        time=min; //setting minimum time
            for(int i=0;i<ar.size();i++)
        {
        if(Integer.parseInt(ar.get(i))==min)
        {
          arp.add(pr.get(i)+" "+(i+1)+" "+Integer.parseInt((ab.get(i)).substring(0,(ab.get(i)).indexOf(" "))));
          v[i]=true;
        }
        }
         Collections.sort(arp,new Sortby()); //sorting by priority
         while(time!=(sum+min))
        {
            time++; //incrementing time
            g=(arp.get(0)); //getting minimum priority
            arp.set(0,g.substring(0,g.lastIndexOf(" "))+" "+ (Integer.parseInt(g.substring(g.lastIndexOf(" ")+1,g.length()))-1));
            seq=seq+g.substring(g.indexOf(" ")+1,g.lastIndexOf(" ")); //sequence of processes in CPU
         if((Integer.parseInt((arp.get(0)).substring((arp.get(0)).lastIndexOf(" ")+1,(arp.get(0)).length())))==0)
               arp.remove(0); //removing completed process
        for(int i=0;i<count;i++)
        {
        if(Integer.parseInt(at1[i])<=time && v[i]==false)
        {
           arp.add(pr.get(i)+" "+(i+1)+" "+Integer.parseInt((ab.get(i)).substring(0,(ab.get(i)).indexOf(" "))));
           v[i]=true; //to mark it visited
        }
        }
            Collections.sort(arp,new Sortby());
           
        }
        int c=0,k=0;
      prlb1=new JLabel[200*count];
      JLabel l[]=new JLabel[200*count]; 
           sa=0;
           for(int i=0;i<seq.length();i++)
           {
               c=0;
              for(int j=sa;j<seq.length();j++)
              {
                  c++; //incrementing count
                  char ch=seq.charAt(j);
                  if(j!=seq.length()-1)
                  {
                  if(ch!=seq.charAt(j+1))
                      break;
                  }
                  else 
                      break;
              }
              prlb1[k]=new JLabel("P"+seq.charAt(sa));
               y.add(temp.get(k));
              (temp.get(k)).setBorder(bor);
              (temp.get(k)).setBounds((y.getWidth()*(sa+c))/sum,0,3,(y.getHeight()*3)/4);
        y.add(prlb1[k]);
        prlb1[i].setBounds(2+y.getWidth()*(sa+c/2)/sum,20,25,25);
        l[k]=new JLabel(Integer.toString(sa+min));
            y.add(l[k]); //adding timeline
            l[k].setBounds((y.getWidth()*sa)/sum,(y.getHeight()*3)/4,42,20);
              k++;
               sa=sa+c; //total count
              if(sa==sum)
                  break;
           } 
            JPanel newTemp=new JPanel();
        y.add(newTemp);
      newTemp.setBounds(0,(y.getHeight()*3)/4,y.getWidth(),2); 
      newTemp.setBorder(bor);
             l[k]=new JLabel(Integer.toString(sa+min));
             y.add(l[k]);
        l[k].setBounds(y.getWidth()-19,(y.getHeight()*3)/4,42,20);
        for(int i=0;i<count;i++){
       tat1=tat1+"P"+(i+1)+" = "+(1+min+seq.lastIndexOf(Integer.toString(i+1))-Integer.parseInt(at1[i]))+"     ";
       tats=tats+(1+min+seq.lastIndexOf(Integer.toString(i+1))-Integer.parseInt(at1[i]));
       wt1=wt1+"P"+(i+1)+" = "+(1+min+seq.lastIndexOf(Integer.toString(i+1))-Integer.parseInt(at1[i])-Integer.parseInt(bt1[i]))+"     ";
       wts=wts+(1+min+seq.lastIndexOf(Integer.toString(i+1))-Integer.parseInt(at1[i])-Integer.parseInt(bt1[i]));
        }
        double avgt=tats/count; //average turn around time
        double avgw=wts/count; //average waiting time
        tat1=tat1+"     "+"Average turn around time: "+avgt;
        wt1=wt1+"     "+"Average waiting time: "+avgw;
        JLabel w=new JLabel("Wait time: "+wt1);
      w.setFont(f3);
      JLabel ta=new JLabel("Turn Around time: "+tat1);
      ta.setFont(f3); //setting font
         op15.add(w);
         op15.add(ta);
    }
    public void NonSJF()
    {
        JLabel jl=new JLabel("Non-Preemptive SJF");
        jl.setFont(f2);
        x.removeAll(); //removing previous chart
        op14.removeAll();
        x.setLayout(null);
        x.setBackground(Color.white); //to set background white
        op14.add(jl);
        x.setBorder(bor); //setting border
        String g="",seq="",g1="";
        double tats=0,wts=0; //for calculating times
        int val,val1,sa=0,time=0;
        String tat1="",wt1="";
        int []wt=new int[count];
        int []tat=new int[count];
        Arrays.fill(v,false);
        ArrayList<String> ar=new ArrayList<String>(Arrays.asList(at1));
         ArrayList<String> arr=new ArrayList<String>(ab);
         Collections.sort(arr,new Sortby()); //for sorting burst time
                 for(int i=0;i<ar.size();i++)
        {
            ar.set(i,ar.get(i)+" "+(i+1));
        }
        Collections.sort(ar,new Sortby()); //for sorting by arrival time
                ArrayList<JPanel> temp=new ArrayList<JPanel>();
        JLabel []prlb=new JLabel[count]; 
      JLabel l[]=new JLabel[count+1];
        for(int i=0;i<count;i++)
            temp.add(new JPanel());
        String mi=(String)Collections.min(ar);
        int min=Integer.parseInt(mi.substring(0,mi.indexOf(' ')));
        time=min; //minimum time
        int i,flag=0;
                while(time!=(sum+min))
        {
           for( i=0;i<count;i++)
             {
                 g=arr.get(i); //getting shortest job
       for(int j=0;j<ar.size();j++)
            {
                g1=ar.get(j);
                if(Integer.parseInt(g.substring(g.indexOf(' ')+1,g.length()))==Integer.parseInt(g1.substring(g1.indexOf(' ')+1,g1.length())) && v[j]==false && Integer.parseInt(g1.substring(0,g1.indexOf(' ')))<=time)
                {
                    v[j]=true;
                    flag=1;
                    break;
                }
                
            }  
                 if(flag==1)
                    break;
             }
           flag=0;
        val1=Integer.parseInt(g.substring(0,g.indexOf(' ')));
             val=Integer.parseInt(g.substring(g.indexOf(' ')+1,g.length())); 
            x.add(temp.get(i));
            (temp.get(i)).setBorder(bor); //to set border
            (temp.get(i)).setBounds((x.getWidth()*(sa+val1))/sum,0,3,(x.getHeight()*3)/4);
            prlb[i]=new JLabel("P"+val);
      x.add(prlb[i]); //adding process name
      prlb[i].setBounds(2+x.getWidth()*(sa+val1/2)/sum,20,25,25);
      l[i]=new JLabel(Integer.toString(sa+Integer.parseInt((ar.get(0)).substring(0,(ar.get(0)).indexOf(' ')))));
      x.add(l[i]);
      l[i].setBounds((x.getWidth()*sa)/sum,(x.getHeight()*3)/4,42,20);
            sa=sa+val1;
       tat[val-1]=sa+Integer.parseInt((ar.get(0)).substring(0,(ar.get(0)).indexOf(' ')))-Integer.parseInt(at1[val-1]);
       wt[val-1]=tat[val-1]-Integer.parseInt(bt1[val-1]);
        time=time+val1; //incrementing time
        
        }
                 JPanel newTemp=new JPanel();
        x.add(newTemp);
      newTemp.setBounds(0,(x.getHeight()*3)/4,x.getWidth(),2); 
      newTemp.setBorder(bor);
             l[count]=new JLabel(Integer.toString(sa+Integer.parseInt((ar.get(0)).substring(0,(ar.get(0)).indexOf(' ')))));
             x.add(l[count]);
              l[count].setBounds(x.getWidth()-19,(x.getHeight()*3)/4,42,20);  
        for(int s=0;s<count;s++)
                {
                    wt1=wt1+"P"+(s+1)+" = "+wt[s]+"     ";
                    tat1=tat1+"P"+(s+1)+" = "+tat[s]+"     ";
                    tats=tats+tat[s]; //total turn around time
                    wts=wts+wt[s]; //total wait time
                }
         double avgt=tats/count;
         double avgw=wts/count;
      JLabel w=new JLabel("Wait time: "+wt1+"     "+"Average waiting time: "+avgw);
      w.setFont(f3);
      JLabel ta=new JLabel("Turn Around time: "+tat1+"     "+"Average turn around time: "+avgt);
      ta.setFont(f3);
                op14.add(w); //displaying wait times
                op14.add(ta); //displaying turn around time
    }
    public void Round()
    {
        JLabel jl=new JLabel("Round Robin");
        jl.setFont(f2);
        q.removeAll(); //removing previous chart
        op13.removeAll();
        q.setLayout(null);
        q.setBackground(Color.white);
        op13.add(jl); //adding CPU scheduling name
        q.setBorder(bor);
        String g="",seq=""; //declaring variables
        String wt1="",tat1="";
        double tats=0,wts=0;
        int rr=0; //to maintain index
        Arrays.fill(v,false);
        ArrayList<String> arr=new ArrayList<String>();
    ArrayList<String> ar=new ArrayList<String>(Arrays.asList(at1));
    for(int i=0;i<ar.size();i++)
        ar.set(i,ar.get(i)+ " "+i); //appending process index
    Collections.sort(ar,new Sortby());
        int val1,val,sa,time;
        ArrayList<JPanel> temp=new ArrayList<JPanel>();
        JLabel []prlb2; 
        for(int i=0;i<count*200;i++)
            temp.add(new JPanel());
        String mi=(String)Collections.min(ar);
        int min=Integer.parseInt(mi.substring(0,mi.indexOf(' ')));
        time=min; //minimum arrival time
    for(int i=0;i<ar.size();i++)
        {
          arr.add(ab.get(Integer.parseInt((ar.get(i)).substring((ar.get(i)).indexOf(' ')+1,(ar.get(i)).length()))));
        }
    while(time!=(sum+min))
           {

               g=arr.get(0); //getting the first process in ready queue
               if(Integer.parseInt(g.substring(0,g.indexOf(" ")))-Integer.parseInt(tq)>0)
               {
                 arr.set(0,Integer.parseInt(g.substring(0,g.indexOf(" ")))-Integer.parseInt(tq)+ " "+g.substring(g.indexOf(" ")+1,g.length()));
                 for(int n=0;n<Integer.parseInt(tq);n++)
                 seq=seq+g.substring(g.indexOf(" ")+1,g.length()); //sequence of process execution
                 time+=Integer.parseInt(tq);
                 String ele=(String)arr.get(0);
                 String ele1=(String)ar.get(0);
                 arr.remove(0); //removing from ready queue
                 ar.remove(0);
                 for( int j=0;j<ar.size();j++)
                    {
                   String g1=ar.get(j);
                   if(Integer.parseInt(g1.substring(0,g1.indexOf(' ')))>time )
                   {
                 arr.add(j,ele); //placing completed process at end of ready queue
                 ar.add(j,ele1);
                       break;
                   }
                       
                     }
                 if(ar.size()==0 || Integer.parseInt((ar.get(ar.size()-1)).substring(0,(ar.get(ar.size()-1)).indexOf(' ')))<=time )
                      {
                 arr.add(ar.size(),ele);
                 ar.add(ar.size(),ele1);
                 }
                 
               }
               else if(Integer.parseInt(g.substring(0,g.indexOf(" ")))-Integer.parseInt(tq)==0)
               {
                   arr.set(0,Integer.parseInt(g.substring(0,g.indexOf(" ")))-Integer.parseInt(tq)+ " "+g.substring(g.indexOf(" ")+1,g.length()));
                 for(int n=0;n<Integer.parseInt(tq);n++)
                 seq=seq+g.substring(g.indexOf(" ")+1,g.length()); //appending in sequence
                 time+=Integer.parseInt(tq); //incrementing time
                 arr.remove(0);
                 ar.remove(0);
               }
               else if(Integer.parseInt(g.substring(0,g.indexOf(" ")))-Integer.parseInt(tq)<0)
               {
                   int t=Integer.parseInt(g.substring(0,g.indexOf(" ")));
                  arr.set(0,0+ " "+g.substring(g.indexOf(" ")+1,g.length()));
                 for(int n=0;n<t;n++)
                 seq=seq+g.substring(g.indexOf(" ")+1,g.length());
                 time+=t; 
                 arr.remove(0); //removing completed process
                 ar.remove(0);
               }
           }
    int c=0,k=0;
      prlb2=new JLabel[200*count];
      JLabel l[]=new JLabel[200*count]; 
           sa=0;
           for(int i=0;i<seq.length();i++)
           {
               c=0; //setting counter to 0
              for(int j=sa;j<seq.length();j++)
              {
                  c++;
                  char ch=seq.charAt(j); //extracting process id
                  if(j!=seq.length()-1)
                  {
                  if(ch!=seq.charAt(j+1) || c==Integer.parseInt(tq))
                      break;
                  }
                  else 
                      break;
              }
              prlb2[k]=new JLabel("P"+seq.charAt(sa)); //label for process name
               q.add(temp.get(k));
              (temp.get(k)).setBorder(bor);
              (temp.get(k)).setBounds((q.getWidth()*(sa+c))/sum,0,3,(q.getHeight()*3)/4);
        q.add(prlb2[k]);
        prlb2[i].setBounds(2+q.getWidth()*(sa+c/2)/sum,20,25,25);
        l[k]=new JLabel(Integer.toString(sa+min)); //label for timeline
            q.add(l[k]);
            l[k].setBounds((q.getWidth()*sa)/sum,(q.getHeight()*3)/4,42,20);
              k++;
               sa=sa+c; //total count
              if(sa==sum)
                  break;
           } 
            JPanel newTemp=new JPanel();
        q.add(newTemp);
      newTemp.setBounds(0,(q.getHeight()*3)/4,q.getWidth(),2); 
      newTemp.setBorder(bor);
             l[k]=new JLabel(Integer.toString(sa+min));
             q.add(l[k]); //displaying timeline
        l[k].setBounds(q.getWidth()-19,(q.getHeight()*3)/4,42,20);
         for(int i=0;i<count;i++){
       tat1=tat1+"P"+(i+1)+" = "+(1+min+seq.lastIndexOf(Integer.toString(i+1))-Integer.parseInt(at1[i]))+"     ";
       tats=tats+(1+min+seq.lastIndexOf(Integer.toString(i+1))-Integer.parseInt(at1[i]));
       wt1=wt1+"P"+(i+1)+" = "+(1+min+seq.lastIndexOf(Integer.toString(i+1))-Integer.parseInt(at1[i])-Integer.parseInt(bt1[i]))+"     ";
       wts=wts+(1+min+seq.lastIndexOf(Integer.toString(i+1))-Integer.parseInt(at1[i])-Integer.parseInt(bt1[i]));
        }
          double avgt=tats/count; //average turn around time
        double avgw=wts/count; //average wait time
        tat1=tat1+"     "+"Average turn around time: "+avgt;
        wt1=wt1+"     "+"Average waiting time: "+avgw;
        JLabel w=new JLabel("Wait time: "+wt1);
      w.setFont(f3); //setting font
      JLabel ta=new JLabel("Turn Around time: "+tat1);
      ta.setFont(f3);
         op13.add(w);
         op13.add(ta);
    }
public void PreSJF()
{
    JLabel jl=new JLabel("Preemptive SJF");
    jl.setFont(f2);
    p.removeAll();
    op12.removeAll();
    p.setLayout(null); //setting layout null
    p.setBackground(Color.white);
    op12.add(jl);
    p.setBorder(bor); //setting border
    String g,seq="";
    String tat1="",wt1=""; //to calculate times
    double tats=0,wts=0;
    Arrays.fill(v,false);
    ArrayList<String> arr=new ArrayList<String>();
    ArrayList<String> ar=new ArrayList<String>(Arrays.asList(at1));
        int val1,val,sa,time; //declaring variables
        ArrayList<JPanel> temp=new ArrayList<JPanel>();
        JLabel []prlb1;
        for(int i=0;i<count*200;i++)
            temp.add(new JPanel());
        int min=Integer.parseInt((String)Collections.min(ar));
        time=min;
    for(int i=0;i<ar.size();i++)
        {
        if(Integer.parseInt(ar.get(i))==min)
        {
          arr.add(ab.get(i));//adding if arrival time is minimum
          v[i]=true; //marking it visited
        }
        }
        Collections.sort(arr,new Sortby()); //customised sorting
        while(time!=(sum+min))
        {
            time++; //incrementing time
            g=(arr.get(0));
            arr.set(0,Integer.parseInt(g.substring(0,g.indexOf(" ")))-1+ " "+g.substring(g.indexOf(" ")+1,g.length()));
            seq=seq+g.substring(g.indexOf(" ")+1,g.length()); //sequence of process execution
            if((Integer.parseInt((arr.get(0)).substring(0,(arr.get(0)).indexOf(" "))))==0)
               arr.remove(0); //removing completed process from ready queue
        for(int i=0;i<count;i++)
        {
        if(Integer.parseInt(at1[i])<=time && v[i]==false)
        {
           arr.add(ab.get(i));
           v[i]=true;
        }
        }
            Collections.sort(arr,new Sortby());  
        }
        int c=0,k=0; //initializing variables
      prlb1=new JLabel[200*count];
      JLabel l[]=new JLabel[200*count]; 
           sa=0;//initializing total count
           for(int i=0;i<seq.length();i++)
           {
               c=0;
              for(int j=sa;j<seq.length();j++)
              {
                  c++;
                  char ch=seq.charAt(j);
                  if(j!=seq.length()-1)
                  {
                  if(ch!=seq.charAt(j+1))
                      break;
                  }
                  else 
                      break;
              }
              prlb1[k]=new JLabel("P"+seq.charAt(sa));
               p.add(temp.get(k)); //adding divisions in chart
              (temp.get(k)).setBorder(bor);
              (temp.get(k)).setBounds((p.getWidth()*(sa+c))/sum,0,3,(p.getHeight()*3)/4);
        p.add(prlb1[k]);
        prlb1[i].setBounds(2+p.getWidth()*(sa+c/2)/sum,20,25,25);
        l[k]=new JLabel(Integer.toString(sa+min)); //storing time spent
            p.add(l[k]);
            l[k].setBounds((p.getWidth()*sa)/sum,(p.getHeight()*3)/4,42,20);
              k++;
               sa=sa+c; //total process time
              if(sa==sum)
                  break;
           } 
            JPanel newTemp=new JPanel();
        p.add(newTemp); //adding division to chart
      newTemp.setBounds(0,(p.getHeight()*3)/4,p.getWidth(),2); 
      newTemp.setBorder(bor); //setting the border
             l[k]=new JLabel(Integer.toString(sa+min));
             p.add(l[k]); //adding the time spent
        l[k].setBounds(p.getWidth()-19,(p.getHeight()*3)/4,42,20);
        for(int i=0;i<count;i++){
       tat1=tat1+"P"+(i+1)+" = "+(1+min+seq.lastIndexOf(Integer.toString(i+1))-Integer.parseInt(at1[i]))+"     ";
       tats=tats+(1+min+seq.lastIndexOf(Integer.toString(i+1))-Integer.parseInt(at1[i]));
       wt1=wt1+"P"+(i+1)+" = "+(1+min+seq.lastIndexOf(Integer.toString(i+1))-Integer.parseInt(at1[i])-Integer.parseInt(bt1[i]))+"     ";
       wts=wts+(1+min+seq.lastIndexOf(Integer.toString(i+1))-Integer.parseInt(at1[i])-Integer.parseInt(bt1[i]));
        }
         double avgt=tats/count;
        double avgw=wts/count;
        tat1=tat1+"     "+"Average turn around time: "+avgt;
        wt1=wt1+"     "+"Average waiting time: "+avgw;
        JLabel w=new JLabel("Wait time: "+wt1);
      w.setFont(f3); //font of waiting time
      JLabel ta=new JLabel("Turn Around time: "+tat1);
      ta.setFont(f3);
         op12.add(w);
         op12.add(ta); //adding turn around time to panel
             
    
}
    public void FCFS()
    {
        JLabel jl=new JLabel("FCFS");
        jl.setFont(f2);
        o.removeAll(); //removing previous chart
        op11.removeAll();
        o.setLayout(null);
        o.setBackground(Color.white);
        op11.add(jl);
        o.setBorder(bor); //setting border
        String g="",g1; //variables for extracting process
        String wt1="",tat1="";
        double tats=0,wts=0;
        int []wt=new int[count];
        int []tat=new int[count];
        Arrays.fill(v,false); //marking all process unvisited
        ArrayList<String> ar=new ArrayList<String>(Arrays.asList(at1));
        int val1;
        for(int i=0;i<ar.size();i++)
        {
            ar.set(i,ar.get(i)+" "+(i+1)); //appending process id to arrival time
        }
        Collections.sort(ar,new Sortby());
        int val,sa=0;
        ArrayList<JPanel> temp=new ArrayList<JPanel>();
        JLabel []prlb=new JLabel[count]; 
      JLabel l[]=new JLabel[count+1]; //label for timeline
        for(int i=0;i<count;i++)
            temp.add(new JPanel()); //panels to create division
        for(int i=0;i<count;i++)
        {
            
            g1=ar.get(i);
            for(int j=0;j<ab.size();j++)
            {
                g=ab.get(j);
                if(Integer.parseInt(g.substring(g.indexOf(' ')+1,g.length()))==Integer.parseInt(g1.substring(g1.indexOf(' ')+1,g1.length())))
                {
                    break; //break if id match found
                }
            }          
             val1=Integer.parseInt(g.substring(0,g.indexOf(' ')));
             val=Integer.parseInt(g.substring(g.indexOf(' ')+1,g.length())); 
            o.add(temp.get(i));
            (temp.get(i)).setBorder(bor); //setting border
            (temp.get(i)).setBounds((o.getWidth()*(sa+val1))/sum,0,3,(o.getHeight()*3)/4);
            prlb[i]=new JLabel("P"+val); //label of process name
      o.add(prlb[i]);
      prlb[i].setBounds(2+o.getWidth()*(sa+val1/2)/sum,20,25,25);
      l[i]=new JLabel(Integer.toString(sa+Integer.parseInt((ar.get(0)).substring(0,(ar.get(0)).indexOf(' ')))));
      o.add(l[i]); //adding timeline label
      l[i].setBounds((o.getWidth()*sa)/sum,(o.getHeight()*3)/4,42,20);
            sa=sa+val1; //calculating total burst time
       tat[val-1]=sa+Integer.parseInt((ar.get(0)).substring(0,(ar.get(0)).indexOf(' ')))-Integer.parseInt(at1[val-1]);
       wt[val-1]=tat[val-1]-Integer.parseInt(bt1[val-1]); //array of waiting time
        }
        
        JPanel newTemp=new JPanel();
        o.add(newTemp); //adding division panel
      newTemp.setBounds(0,(o.getHeight()*3)/4,o.getWidth(),2); 
      newTemp.setBorder(bor); //setting the border
             l[count]=new JLabel(Integer.toString(sa+Integer.parseInt((ar.get(0)).substring(0,(ar.get(0)).indexOf(' ')))));
             o.add(l[count]);
              l[count].setBounds(o.getWidth()-19,(o.getHeight()*3)/4,42,20);
                for(int i=0;i<count;i++)
                {
                    wt1=wt1+"P"+(i+1)+" = "+wt[i]+"     ";
                    tat1=tat1+"P"+(i+1)+" = "+tat[i]+"     ";
                    tats=tats+tat[i]; //total turn around time
                    wts=wts+wt[i];
                }
         double avgt=tats/count; //average turn around time
         double avgw=wts/count;
         JLabel w=new JLabel("Wait time: "+wt1+"     "+"Average waiting time: "+avgw);
      w.setFont(f3); //setting font of waiting time
      JLabel ta=new JLabel("Turn Around time: "+tat1+"     "+"Average turn around time: "+avgt);
      ta.setFont(f3);
                op11.add(w); 
                op11.add(ta);
      } 
    public static void main(String args[])
    {
        new cpuscheduling(); //creating object of the class
        
    } //end of main method
} //end of main class
class Sortby implements Comparator<String>  //Customised Comparator class
{ 
    public int compare(String a, String b)  //overriding compare method
    { 
        int result,ans,ans1; //local variables
        result=Integer.parseInt(a.substring(0,a.indexOf(' ')))-Integer.parseInt(b.substring(0,b.indexOf(' ')));
        if(result==0) //resolving if values equal
        {
            ans=a.lastIndexOf(' ');
            if(ans==a.indexOf(' '))
                    ans=a.length();
             ans1=b.lastIndexOf(' ');
            if(ans1==b.indexOf(' '))
                    ans1=b.length();
           result=Integer.parseInt(a.substring(a.indexOf(' ')+1,ans))-Integer.parseInt(b.substring(b.indexOf(' ')+1,ans1));
           
        }
        return result; //returning result
    } 
} //end of comparator class
//End of code

