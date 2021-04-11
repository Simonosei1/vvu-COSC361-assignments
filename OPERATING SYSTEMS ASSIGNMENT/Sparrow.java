import java.util.Scanner;
public class Sparrow {
    /* NAMES                ID
   KUDOM SIMON OSEI     219CS01000035
   OKOJOKWA FARIDA      219IT01000185
   ASAMOAH FRANK        219CS01090028
 */

    public static void main(String[] args) {
        int numberOfProcesses = 0, memory_Avail; //Holds number of processes and memory available
        int i;
        int number_Of_Blocks, temp = 0;
        int p = 0;
        char ch = 'y';
        int blockSize;
        int[] mp = new int[20];
        int total_Internal_Frag = 0;
        int total_External_Frag = 0;
        int lowest = 10000;
        int highest=0;
        int choice;
        int[] max = new int[25];
        int[] b = new int[max.length];
        int[] f = new int[max.length];
        int[] bf = new int[max.length];
        int[] ff = new int[max.length];
        int j = 0, number_Of_Files;
        int[] burstTime =new int[20];
        int[] waitingTime=new int[20];
        int[] turn_Around_Time=new int [20];
        float avg_Waiting_time, avg_Turnaround_Time;
        int[] O=new int[20];


        Scanner sc = new Scanner(System.in);

        //Displaying to the user and asking for input from the user.
        System.out.println("A program that displays various memory techniques");

        System.out.println("1.Multiprogramming with fixed variables");
        System.out.println("2.Multiprogramming with various variables");
        System.out.println("3.Worst fit Management Technique");
        System.out.println("4.Best fit Management Technique");
        System.out.println("5.First Fit Management Technique");
        System.out.println("6.Paging Technique");
        System.out.println("7.FCFS CPU SCHEDULING ALGORITHM");
        System.out.println("8.SJF CPU SCHEDULING ALGORITHM");
        System.out.println("9.ROUND ROBIN CPU SCHEDULING ALGORITHM");
        System.out.println("10.PRIORITY CPU SCHEDULING ALGORITHM");
        System.out.println("11.Multi Level Queue Scheduling Algorithm");
        System.out.println("12.FCFS Disk scheduling Alforithm");
        System.out.println("13.Scan Disk Scheduling ALgorithm");
        System.out.println("14.C-Scan Disk Scheduling ALgorithm");
        System.out.println("15.Bankers Algorithm for deadlock avoidance");

        System.out.println("Please select the technique you would like to work with");
        choice = sc.nextInt();

        // A loop that prompts the user if a wrong choice is made and ask to make the right choice.
        while (choice < 1 || choice>=20) {
            System.out.println("Please your choice is invalid");
            System.out.println("TRY AGAIN");
            System.out.println("Please select the technique you would like to implement");
            choice = sc.nextInt();
        }

        //Memory management technique with fixed variables
        if (choice == 1) {


            System.out.print("Enter the total memory available (in Bytes) -- ");//Ask user for memory available
            memory_Avail = sc.nextInt();

            System.out.print("Enter the block size (in Bytes) -- "); // Ask user for block size
            blockSize = sc.nextInt();

        //Calculating number of blocks
            number_Of_Blocks = memory_Avail / blockSize;

        // prompt user for processes
            System.out.print("\nEnter the number of processes -- ");
            numberOfProcesses = sc.nextInt();

            //  loop to store memory required values into the mp array variable
            for (i = 0; i < numberOfProcesses; i++) {
                System.out.print("Enter memory required for process " + (i + 1) + " (in Bytes)-- ");
                mp[i] = sc.nextInt();
            }
            System.out.print("\nNo. of Blocks available in memory -- " + number_Of_Blocks);

            System.out.print("\n\nPROCESS\tMEMORY REQUIRED\t ALLOCATED\tINTERNAL FRAGMENTATION");

            //// A loop that displays the process required and calculates the total internal fragmentation

            for (i = 0; i < numberOfProcesses && p < number_Of_Blocks; i++) {
                System.out.print("\n   " + (i + 1) + "   \t\t    " + mp[i]);
                if (mp[i] > blockSize) {
                    System.out.print("\t\t     NO \t\t---");
                } else {
                    System.out.print("\t\t    YES     \t" + (blockSize - mp[i]));
                    total_Internal_Frag = total_Internal_Frag + blockSize - mp[i];
                    p++;
                }
            }
            if (i < numberOfProcesses) {
                System.out.print("\nMemory is Full, Remaining Processes cannot be accomodated");
            }
            System.out.print("\n\nTotal Internal Fragmentation is " + total_Internal_Frag);
            System.out.print("\nTotal External Fragmentation is " + total_External_Frag);

            //Management technique with various variables
        } else if (choice == 2) {

        //Ask user for input of memory available
            System.out.print("\nEnter the total memory available (in Bytes)-- ");
            memory_Avail = sc.nextInt();

            temp = memory_Avail;

            //A loop that will determine if memory is full.
            for (i = 0; ch == 'y'; i++, numberOfProcesses++) {
                System.out.print("\nEnter memory required for process " + (i + 1) + " (in Bytes) -- ");
                mp[i] = sc.nextInt();

                if (mp[i] <= temp) {
                    System.out.print("\nMemory is allocated for Process " + (i + 1) + " ");
                    temp = temp - mp[i];

                    System.out.println("Do you want to continue(y/n)");
                    ch = sc.next().charAt(0);

                }
            } System.out.println("\n\nTotal Memory Available " + memory_Avail);

            System.out.println("\n\n\tPROCESS\t\t MEMORY ALLOCATED ");

            // loop to display memory require for processing
            for(i = 0; i < numberOfProcesses; i++){
                System.out.println("\n \t%d\t\t%d"+ i+1 + mp[i]);
            }

            // display allocated memory ma - temp which holds the memory size value).
            int total_Mem_Allocated = memory_Avail - temp;//Total Memory Allocated calculation.

            System.out.println("Total Memory Allocated is " + total_Mem_Allocated );
            System.out.println("Total External Fragmentation is " + temp);


            //Worst Fit Management technique
        } else if (choice == 3) {


            System.out.println("Enter the number of blocks"); //prompt user for input
            number_Of_Blocks = sc.nextInt();

            System.out.println("Enter the number of files");//prompt user to input
            number_Of_Files = sc.nextInt();

            System.out.println("Enter the size of the blocks");//prompt user for input

            //A loop that stores the number of blocks
            for (i = 1; i <= number_Of_Blocks; i++) {
                System.out.println("Block:" + i);
                b[i] = sc.nextInt();
            }
            System.out.println("Enter the size of files");//prompt user for input
            //A loop that stores the number of files
            for (i = 1; i <= number_Of_Files; i++) {
                System.out.println("File" + i);
                f[i] = sc.nextInt();
            }
            for (i = 1; i <= number_Of_Files; i++) {
                for (j = 1; j <= number_Of_Blocks; j++) {
                    if (bf[j] != 1) {
                        temp = b[j] - f[i];
                        if (temp >= 0) {
                            ff[i] = j;
                            break;
                        }
                    }
                }

                f[i] = temp;
                bf[ff[i]] = 1;

            }
            System.out.println("\nFile_no\tFile_size \tBlock_no\tBlock_size\tFragment");//Displays table to user
            for (i = 1; i <= number_Of_Files; i++)

                System.out.println(i + "\t\t\t" + f[i] + "\t\t\t" + ff[i] + "\t\t\t" + b[ff[i]] + "\t\t\t" + f[i]);

            //Best Fit Technique

        } else if (choice == 4) {

            System.out.println("Enter the number of blocks");
            number_Of_Blocks = sc.nextInt();

            System.out.println("Enter the number of files");
            number_Of_Files = sc.nextInt();

            System.out.println("Enter the size of the blocks");
            //A loop that stores the number of blocks
            for (i = 1; i <= number_Of_Blocks; i++) {
                System.out.println("Block:" + i);
                b[i] = sc.nextInt();
            }
            System.out.println("Enter the size of files");

            //A loop that stores the number of files
            for (i = 1; i <= number_Of_Files; i++)
            {
                System.out.println("File" + i);
                f[i] = sc.nextInt();
            }

            for (i = 1; i <= number_Of_Files; i++)
            {
                for (j = 1; j <= number_Of_Blocks; j++)
                {
                    if (bf[j] != 1)
                    {
                        temp = b[j] - f[i];

                        if (temp >= 0)

                            if (lowest > temp)
                            {
                                ff[i] = j;
                                lowest = temp;

                            }
                    }
                }

                ff[i] = lowest;
                bf[ff[i]] = 1;
                lowest = 10000;
            }

            System.out.println("\nFile_no\tFile_size \tBlock_no\tBlock_size\tFragment");//Displays a table to the user containing the respective values
            for (i = 1; i <= number_Of_Files && ff[i]!=0; i++) {
                System.out.println(i + "\t\t\t" + f[i] + "\t\t\t" + ff[i] + "\t\t\t" + b[ff[i]] + "\t\t\t" + f[i]);
            }
        }else

            //First Fit Technique
            if(choice==5){

                System.out.println("Enter the number of blocks:");
                number_Of_Blocks= sc.nextInt();
                System.out.println("Enter the number of files:");
                number_Of_Files= sc.nextInt();
                System.out.println("Enter the size of the blocks:-\n");

                // A loop that stores the number of blocks.
                for(i=1; i <= number_Of_Blocks; i++){
                    System.out.println("Block" + i);
                    b[i]= sc.nextInt();
                }
                System.out.println("Enter the size of the files ");
                for(i=1; i <= number_Of_Files; i++)
                {
                    System.out.println("File"+i);
                    f[i]= sc.nextInt();
                }
                for(i=1; i<=number_Of_Files; i++)
                //A loop storing the number of files
                {

                    for(j=1; j <=number_Of_Blocks; j++)
                    {
                        if(bf[j]!=1) //if bf[j] is not allocated
                        {
                            temp=b[j]-f[i];
                            if(temp>=0)
                                if(highest<temp)
                                {
                                    ff[i]=j;
                                    highest=temp;
                                }
                        }
                    }
                    f[i]=highest;
                    bf[ff[i]]=1;
                    highest=0;
                }
                System.out.println("\nFile_no\tFile_size \tBlock_no\tBlock_size\tFragment");
                for (i = 1; i <= number_Of_Files; i++) {
                    System.out.println(i + "\t\t\t" + f[i] + "\t\t\t" + ff[i] + "\t\t\t" + b[ff[i]] + "\t\t\t" + f[i]);
                }


            }else

                //Paging management technique.
                if(choice==6){

                    int[] s=new int[10];
                    int[][] fno=new int[10][20];
                    int processes_Num; //stores the process number
                    int paging_Num;  //Stores the paging number
                    int page_Size;  //Stores the pages size
                    int page_Avail;  //Stores Page available
                    int number_Of_Pages;  //Stores the number  of pages
                    int rempages;
                    int memory_Size;        //Stores the memory size
                    int offset;     //Stores the offset.

                    System.out.println("Enter the memory size  ");
                    memory_Size = sc.nextInt();

                    System.out.println("Enter the page size");
                    page_Size = sc.nextInt();

                    number_Of_Pages = memory_Size/page_Size; //Calculating the number pages.

                    System.out.println("The no. of pages available in memory are  " + number_Of_Pages);
                    System.out.println("Enter number of processes");
                    numberOfProcesses = sc.nextInt();
                    rempages = number_Of_Pages;

                    for(i=1; i<=numberOfProcesses; i++)
                    {
                        System.out.println("Enter no. of pages required for p "+i);
                        s[i] = sc.nextInt();
                        if(s[i] >rempages)
                        {
                            System.out.println("Memory is Full");
                            break;
                        }
                        rempages = rempages - s[i];
                        System.out.printf("Enter pagetable for p[%d] --- ",i);
                        for(j=0;j<s[i];j++)
                            fno[i][j] = sc.nextInt();
                    }
                    System.out.println("Enter Logical Address to find Physical Address ");
                    System.out.println("Enter process no. ");
                    processes_Num = sc.nextInt();

                    System.out.println("Enter page number ");
                    paging_Num = sc.nextInt();

                    System.out.println("Enter offset ");
                    offset = sc.nextInt();

                    if(processes_Num > numberOfProcesses || paging_Num >= s[i] || offset >= page_Size)
                        System.out.println("Invalid Process or Page Number or offset");
                    else
                    {
                        page_Avail=fno[processes_Num] [paging_Num] * page_Size+offset;
                        System.out.println("The Physical Address is "+ page_Avail);


                    }
                }else
                if(choice==7){

                    ;
                    System.out.println("Enter the number of processes");
                    numberOfProcesses= sc.nextInt();

                    for(i=0; i < numberOfProcesses; i++)
                    {
                        System.out.println("Enter Burst Time for Process"+ " " + i);
                        burstTime[i]= sc.nextInt();
                    }
                    waitingTime[0] = (int) (avg_Waiting_time = 0);
                    turn_Around_Time[0] = (int) (avg_Turnaround_Time = burstTime[0]);

                    for(i=1; i < numberOfProcesses; i++)
                    {
                        waitingTime[i] = waitingTime[i-1] +burstTime[i-1];
                        turn_Around_Time[i] = turn_Around_Time[i-1] +burstTime[i];
                        avg_Waiting_time = avg_Waiting_time + waitingTime[i];
                        avg_Turnaround_Time = avg_Turnaround_Time + turn_Around_Time[i];
                    }
                    System.out.println("\t PROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME\n");

                    for(i=0; i <numberOfProcesses; i++)
                        System.out.println("\t\t"+i+"\t"+"\t\t"+burstTime[i]+"\t\t\t"+ waitingTime[i]+"\t\t\t\t\t"+ turn_Around_Time[i]);

                    System.out.println("\nAverage Waiting Time" +" "+avg_Waiting_time);
                    System.out.println("\nAverage Turnaround Time" + " "+ avg_Turnaround_Time);


                }else
                if (choice==8){



                    System.out.println("Enter the number of processes");
                    numberOfProcesses = sc.nextInt();

                    int[] x = new int[20];
                    for(i=0; i<numberOfProcesses; i++)
                    {
                        x[i]=i;
                        System.out.println("Enter Burst Time for Process"+""+ i);
                        burstTime[i]=sc.nextInt();
                    }
                    int k;
                    for(i=0; i<numberOfProcesses; i++)
                        for(k=i+1; k<numberOfProcesses; k++)
                            if(burstTime[i]>burstTime[k])
                            {
                                temp=burstTime[i];
                                burstTime[i]=burstTime[k];
                                burstTime[k]=temp;
                                temp=x[i];
                                x[i]=x[k];
                                x[k]=temp;
                            }

                    waitingTime[0] = (int) (avg_Waiting_time = 0);

                    turn_Around_Time[0] = (int) (avg_Turnaround_Time = burstTime[0]);
                    for(i=1; i<numberOfProcesses; i++)
                    {
                        waitingTime[i] = waitingTime[i-1] +burstTime[i-1];
                        turn_Around_Time[i] = turn_Around_Time[i-1] +burstTime[i];
                        avg_Waiting_time = avg_Waiting_time + waitingTime[i];
                        avg_Turnaround_Time = avg_Turnaround_Time + turn_Around_Time[i];
                    }
                    System.out.println("\t PROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME\n");
                    for(i=0; i<numberOfProcesses; i++)
                        System.out.println("\t\t"+i+"\t"+"\t\t"+burstTime[i]+"\t\t\t"+ waitingTime[i]+"\t\t\t\t\t"+ turn_Around_Time[i]);

                    System.out.println("Average Waiting Time" +" "+avg_Waiting_time);
                    System.out.println("Average Turnaround Time" + " "+ avg_Turnaround_Time);

                }else
                if(choice==9){


                    int maxi;
                    int size_Of_Timeslice;
                    int[] ct=new int[10];

                    float avg_Waiting_Time= 0;
                    avg_Turnaround_Time = 0;

                    System.out.println("Enter the no of processes");
                    numberOfProcesses = sc.nextInt();

                    for(i=0;i < numberOfProcesses; i++)
                    {
                        System.out.println("Enter Burst Time for process" +""+ i);
                        burstTime[i]= sc.nextInt();
                        ct[i]=burstTime[i];
                    }
                    System.out.println("Enter the size of time slice ");
                    size_Of_Timeslice= sc.nextInt();
                    maxi=burstTime[0];
                    for(i=1;i < numberOfProcesses; i++)

                        if(maxi<burstTime[i])

                            maxi=burstTime[i];

                    for(j=0;j<(maxi/size_Of_Timeslice)+1;j++)

                        for(i=0;i < numberOfProcesses; i++)

                            if(burstTime[i]!=0)

                                if(burstTime[i]<=size_Of_Timeslice)
                                {
                                    turn_Around_Time[i]= temp+burstTime[i];

                                    temp = temp+burstTime[i];

                                    burstTime[i]=0;
                                }
                                else
                                {
                                    burstTime[i]=burstTime[i]-size_Of_Timeslice;

                                    temp = temp+size_Of_Timeslice;
                                }
                    for(i=0; i < numberOfProcesses; i++)
                    {
                        waitingTime[i] = turn_Around_Time[i] - ct[i];

                        avg_Turnaround_Time += turn_Around_Time[i];

                        avg_Waiting_Time += waitingTime[i];
                    }
                    System.out.println("The Average Turnaround time is"+" " + avg_Turnaround_Time);
                    System.out.println("The Average Waiting time is"+ ""+ avg_Waiting_Time);

                    System.out.println("\t PROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME\n");
                    for(i=0;i < numberOfProcesses; i++)
                        System.out.println("\t\t"+i+"\t"+"\t\t"+ct[i]+"\t\t\t"+ waitingTime[i]+"\t\t\t\t\t"+ turn_Around_Time[i]);


                }else
                if(choice==10){


                    int[] pri=new int[20];
                    int k;


                    System.out.println("Enter the number of processes");
                    numberOfProcesses=sc.nextInt();
                    for(i=0;i <numberOfProcesses; i++)
                    {
                        O[i] = i;
                        System.out.println("Enter the Burst Time & Priority of Process" + " "+i);
                        burstTime[i]= sc.nextInt();
                        pri[i]=sc.nextInt();
                    }
                    for(i=0;i < numberOfProcesses; i++)
                        for(k=i+1; k <numberOfProcesses; k++)
                            if(pri[i] > pri[k])
                            {
                                temp=O[i];
                                O[i]=O[k];
                                O[k]=temp;
                                temp=burstTime[i];
                                burstTime[i]=burstTime[k];
                                burstTime[k]=temp;
                                temp=pri[i];
                                pri[i]=pri[k];
                                pri[k]=temp;
                            }
                    avg_Waiting_time = waitingTime[0] = 0;
                    avg_Turnaround_Time = turn_Around_Time[0] = burstTime[0];

                    for(i=1;i <numberOfProcesses; i++)
                    {
                        waitingTime[i] = waitingTime[i-1] + burstTime[i-1];
                        turn_Around_Time[i] = turn_Around_Time[i-1] + burstTime[i];
                        avg_Waiting_time = avg_Waiting_time + waitingTime[i];
                        avg_Turnaround_Time = avg_Turnaround_Time + turn_Around_Time[i];
                    }
                    System.out.println("PROCESS\t\tPRIORITY\tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
                    for(i=0; i <numberOfProcesses; i++)
                        System.out.println(O[i] +"\t\t\t\t"+pri[i]+"\t\t\t"+burstTime[i]+ "\t\t\t"+waitingTime[i]+"\t\t\t"+turn_Around_Time[i]);
                    System.out.println("\nAverage Waiting Time is" +" "+ avg_Waiting_time);
                    System.out.println("\nAverage Turnaround Time is" + " "+ avg_Turnaround_Time);
                }else
                if(choice==11){


                    int[] sys_User= new int[20];



                    System.out.println("Enter the number of processes --- ");
                    numberOfProcesses= sc.nextInt();
                    for(i=0; i <numberOfProcesses; i++)
                    {
                        O[i] = i;
                        System.out.println("Enter the Burst Time of Process"+ " "+ i);
                        burstTime[i]= sc.nextInt();
                        System.out.println("System/User Process (0/1) ? --- ");
                        sys_User[i]= sc.nextInt();
                    }
                    int k;
                    for(i=0; i <numberOfProcesses; i++)
                        for(k=i+1; k < numberOfProcesses; k++)
                            if(sys_User[i] > sys_User[k])
                            {
                                temp=O[i];
                                O[i]=O[k];
                                O[k]=temp;
                                temp=burstTime[i];
                                burstTime[i]=burstTime[k];
                                burstTime[k]=temp;
                                temp=sys_User[i];
                                sys_User[i]=sys_User[k];
                                sys_User[k]=temp;
                            }
                    avg_Waiting_time = waitingTime[0] = 0;
                    avg_Turnaround_Time = turn_Around_Time[0] = burstTime[0];
                    for(i=1; i< numberOfProcesses; i++)
                    {
                        waitingTime[i] = waitingTime[i-1] + burstTime[i-1];
                        turn_Around_Time[i] = turn_Around_Time[i-1] + burstTime[i];

                        avg_Waiting_time = avg_Waiting_time + waitingTime[i];
                        avg_Turnaround_Time = avg_Turnaround_Time + turn_Around_Time[i];
                    }
                    System.out.println("PROCESS\t\t SYSTEM/USER PROCESS \tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
                    for(i=0; i< numberOfProcesses; i++)
                        System.out.println(O[i]+"\t\t\t\t"+sys_User[i]+"\t\t\t\t\t\t"+burstTime[i]+"\t\t\t\t"+waitingTime[1]+"\t\t\t\t"+turn_Around_Time[i]);
                    System.out.println("Average Waiting Time is"+" "+avg_Waiting_time);
                    System.out.println("Average Turnaround Time is"+ " "+avg_Turnaround_Time);


                }else
                if(choice==12){
                    int[] t = new int[20];
                    int num_Of_tracks; //No of tracks
                    int[] tohm=new int [20];
                    int tot=0;
                    float avhm = 0;

                    System.out.println("Enter the no.of tracks");
                    num_Of_tracks= sc.nextInt();
                    System.out.println("Enter the tracks to be traversed");
                    for(i=2;i<num_Of_tracks+2;i++)
                        t[i] = sc.nextInt();

                    for(i=1; i<num_Of_tracks+1; i++)
                    {
                        tohm[i]=t[i+1]-t[i];
                        if(tohm[i]<0)
                            tohm[i]=tohm[i]*(-1);
                    }
                    for(i=1;i<num_Of_tracks+1;i++) {
                        tot += tohm[i];
                        avhm = (float) tot / num_Of_tracks;
                        System.out.println("Tracks traversed\tDifference between tracks\n");

                        for(i=1;i<num_Of_tracks+1;i++)
                            System.out.println("\t\t"+t[i] +"\t\t\t"+ tohm[i]);
                    }

                    System.out.println("\nAverage header movements:"+ avhm);





                }else
                if(choice==13){
                    int[] t=new int[20];
                    int[] d=new int[20]; int h, k;
                    int[] atr=new int[20];
                    int tot, sum=0;

                    System.out.println("enter the no of tracks to be traveresed");
                    int not = sc.nextInt();
                    System.out.println("enter the position of head");
                    h= sc.nextInt();
                    t[0]=0;t[1]=h;
                    System.out.println("enter the tracks");
                    for(i=2; i < numberOfProcesses+2; i++)
                        t[i]= sc.nextInt();
                    for(i=0; i <numberOfProcesses+2; i++)
                    {
                        for(j=0;j < (numberOfProcesses + 2)-i-1;j++)
                        { if(t[j]>t[j+1])
                        {
                            temp=t[j];
                            t[j]=t[j+1];
                            t[j+1]=temp;
                        } } }
                    for(i=0;i < numberOfProcesses+2; i++)
                        if(t[i]==h)
                            j=i;k=i;
                    p=0;
                    while(t[j]!=0)
                    {
                        atr[p]=t[j];
                        j--;
                        p++;
                    }
                    atr[p]=t[j];
                    for(p=k+1; p < numberOfProcesses+2; p++,k++)
                        atr[p]=t[k+1];
                    for(j=0; j < numberOfProcesses+1; j++)
                    {
                        if(atr[j]>atr[j+1])
                            d[j]=atr[j]-atr[j+1];
                        else
                            d[j]=atr[j+1]-atr[j];
                        sum+=d[j];

                        System.out.println("Tracks traversed\tDifference between tracks\n");

                    }
                    System.out.println("\nAverage header movements:" + (float)sum);

                }

    }



}


