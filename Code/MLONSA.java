import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Collections;

public class MLONSA {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        Process_Dataset pd = new Process_Dataset();
        Process_Result pr = new Process_Result();
        
        String inputPath_ProcessDataset_Cloud = "Input\\"
                + "Cloud_Dataset\\";
        String inputPath_ProcessDataset_Fixed_Front = "Input\\"
                + "FixedFront_Dataset\\";
        String inputPath_ProcessDataset_Worst = "Input\\"
                + "Worst_Dataset\\";
        
        String inputPath_ProcessResult_Cloud = "Output\\"
                + "Cloud_Dataset\\";
        String inputPath_ProcessResult_Fixed_Front = "Output\\"
                + "FixedFront_Dataset\\";
        String inputPath_ProcessResult_Worst = "Output\\"
                + "Worst_Dataset\\";
        
        pd.processCloudDataset(inputPath_ProcessDataset_Cloud, inputPath_ProcessResult_Cloud);
        pd.processFixedFrontDataset(inputPath_ProcessDataset_Fixed_Front, inputPath_ProcessResult_Fixed_Front);
        pd.processWorstData(inputPath_ProcessDataset_Worst, inputPath_ProcessResult_Worst);

        pr.CloudResult(inputPath_ProcessResult_Cloud);
        pr.FixedFrontResult(inputPath_ProcessResult_Fixed_Front);
        pr.WorstResult(inputPath_ProcessResult_Worst);
    }
}

class Cloud_Data {
    private int noPoint; 
    private int noObj; 
    private int domComp; 
    private long time;
    private int noFront;
    
    public Cloud_Data () {
        
    }

    public Cloud_Data(int noPoint, int noObj, int domComp, long time, int noFront) {
        this.noPoint = noPoint;
        this.noObj = noObj;
        this.domComp = domComp;
        this.time = time;
        this.noFront = noFront;
    }
    
    public Cloud_Data(Cloud_Data cd) {
        this.noPoint = cd.noPoint;
        this.noObj = cd.noObj;
        this.domComp = cd.domComp;
        this.time = cd.time;
        this.noFront = cd.noFront;
    }

    public int getNoPoint() {
        return noPoint;
    }

    public int getNoObj() {
        return noObj;
    }

    public int getDomComp() {
        return domComp;
    }

    public long getTime() {
        return time;
    }

    public int getNoFront() {
        return noFront;
    }

    public void setNoPoint(int noPoint) {
        this.noPoint = noPoint;
    }

    public void setNoObj(int noObj) {
        this.noObj = noObj;
    }

    public void setDomComp(int domComp) {
        this.domComp = domComp;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setNoFront(int noFront) {
        this.noFront = noFront;
    }

    @Override
    public String toString() {
        return "Cloud_Data{" + "noPoint=" + noPoint + ", noObj=" + noObj + ", domComp=" + domComp + ", time=" + time + ", noFront=" + noFront + '}';
    }

    public static Comparator<Cloud_Data> noPointComparator = new Comparator<Cloud_Data>() {
        @Override
        public int compare(Cloud_Data cd1, Cloud_Data cd2) {
            int noPoint1 = cd1.getNoPoint();
            int noPoint2 = cd2.getNoPoint();
            return noPoint1-noPoint2;
        }
    };
}

class FixedFront_Data {
    private int noPoint; 
    private int noObj; 
    private int domComp; 
    private long time;
    private int noFront;
    
    
    
    public FixedFront_Data () {
        
    }

    public FixedFront_Data(int noPoint, int noObj, int domComp, long time, int noFront) {
        this.noPoint = noPoint;
        this.noObj = noObj;
        this.domComp = domComp;
        this.time = time;
        this.noFront = noFront;
    }
    
    public FixedFront_Data(FixedFront_Data fd) {
        this.noPoint = fd.noPoint;
        this.noObj = fd.noObj;
        this.noFront = fd.noFront;
        this.domComp = fd.domComp;
        this.time = fd.time;
    }

    public int getNoPoint() {
        return noPoint;
    }

    public int getNoObj() {
        return noObj;
    }

    public int getNoFront() {
        return noFront;
    }

    public int getDomComp() {
        return domComp;
    }

    public long getTime() {
        return time;
    }

    public void setNoPoint(int noPoint) {
        this.noPoint = noPoint;
    }

    public void setNoObj(int noObj) {
        this.noObj = noObj;
    }

    public void setNoFront(int noFront) {
        this.noFront = noFront;
    }

    public void setDomComp(int domComp) {
        this.domComp = domComp;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "FixedFront_Data{" + "noPoint=" + noPoint + ", noObj=" + noObj + ", noFront=" + noFront + ", domComp=" + domComp + ", time=" + time + '}';
    }

    public static Comparator<FixedFront_Data> noFrontComparator = new Comparator<FixedFront_Data>() {
        @Override
        public int compare(FixedFront_Data fd1, FixedFront_Data fd2) {
            int noFront1 = fd1.getNoFront();
            int noFront2 = fd2.getNoFront();
            return noFront1-noFront2;
        }
    };
}

class Global {
    public static LinkedList<LinkedList<Integer>> setFrontsLONSA = new LinkedList<>();
    public static LinkedList<LinkedList<Integer>> setFrontsmLONSA = new LinkedList<>();
    public static LinkedList<LinkedList<Integer>> setFrontsFNDS = new LinkedList<>();
    public static LinkedList<LinkedList<Integer>> setFrontsDS = new LinkedList<>();
    public static LinkedList<LinkedList<Integer>> setFrontsENS = new LinkedList<>();
    public static LinkedList<LinkedList<Integer>> setFrontsENSNDT = new LinkedList<>();
    
    public static int domCompLONSA;
    public static int domCompmLONSA;
    public static int domCompFNDS;
    public static int domCompDS;
    public static int domCompENS;
    public static int domCompENSNDT;
    
    public static long timeLONSA;
    public static long timemLONSA;
    public static long timeFNDS;
    public static long timeDS;
    public static long timeENS;
    public static long timeENSNDT;
    
    public static int noFront;
}

class MergeSort {
    void mergeFirstObjective(Point population[], int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if(population[L[i]].isSmall(population[R[j]]) != -1) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    void sortFirstObjective(Point population[], int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sortFirstObjective(population, arr, l, m);
            sortFirstObjective(population, arr, m + 1, r);
            mergeFirstObjective(population, arr, l, m, r);
        }
    }
    
    int[] sortFirstObjective(Point population[]) {
        int n = population.length;
        int[] Q0 = new int[n];
        for(int i = 0; i < n; i++) {
            Q0[i] = population[i].getId();
        }
        sortFirstObjective(population, Q0, 0, population.length-1);
        return Q0;
    }

    void mergeSecondObjective(Point population[], int arr[], int Q0Order[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if(population[L[i]].isSmall(population[R[j]],Q0Order, 1) != -1) {  // L[i] is either small or same
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            } 
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    void sortSecondObjective(Point population[], int arr[], int Q0Order[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sortSecondObjective(population, arr, Q0Order, l, m);
            sortSecondObjective(population, arr, Q0Order, m + 1, r);
            mergeSecondObjective(population, arr, Q0Order, l, m, r);
        }
    }
    
    int[] sortSecondObjective(Point population[], int Q0Order[]) {
        int n = population.length;
        int[] Q0 = new int[n];
        for(int i = 0; i < n; i++) {
            Q0[i] = population[i].getId();
        }
        sortSecondObjective(population, Q0, Q0Order, 0, population.length-1);
        return Q0;
    }
    
    void mergeFirstObjective1(Point population[], int arr[], int l, int m, int r) {
        int n1 = m - l + 1; 
        int n2 = r - m;

        int L[] = new int[n1]; 
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if(population[L[i]].getObjective(0) <= population[R[j]].getObjective(0) ) { 
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    void sortFirstObjective1(Point population[], int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sortFirstObjective1(population, arr, l, m);
            sortFirstObjective1(population, arr, m + 1, r);
            mergeFirstObjective1(population, arr, l, m, r);
        }
    }
    
    int[] sortFirstObjective1(Point population[]) {
        int n = population.length;
        int[] Q0 = new int[n];
        for(int i = 0; i < n; i++) {
            Q0[i] = population[i].getId();
        }
        sortFirstObjective1(population, Q0, 0, population.length-1);
        return Q0;
    }
    
    void mergeSecondObjective1(Point population[], int arr[], int l, int m, int r) {
        int n1 = m - l + 1; 
        int n2 = r - m;
        
        int L[] = new int[n1]; 
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if(population[L[i]].getObjective(1) <= population[R[j]].getObjective(1) ) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            } 
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    void sortSecondObjective1(Point population[], int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sortSecondObjective1(population, arr, l, m);
            sortSecondObjective1(population, arr, m + 1, r);
            mergeSecondObjective1(population, arr, l, m, r);
        }
    }
    
    int[] sortSecondObjective1(Point population[]) {
        int n = population.length;
        int[] Q0 = new int[n];
        for(int i = 0; i < n; i++) {
            Q0[i] = population[i].getId();
        }
        sortSecondObjective1(population, Q0, 0, population.length-1);
        return Q0;
    }
    
    void merge(int arr[], int left, int middle, int right, Point[] population) {
        // Find sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[left + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[middle + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = left;
        while (i < n1 && j < n2) {
            if (population[L[i]].isSmallReverse(population[R[j]]) == 1) { 
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void ReverseLexicographicObjectiveSort(int arr[], int left, int right, Point[] population) {
        if (left < right) {
            // Find the middle point
            int middle = (left+right)/2;
 
            // Sort first and second halves
            ReverseLexicographicObjectiveSort(arr, left, middle, population);
            ReverseLexicographicObjectiveSort(arr , middle+1, right, population);
 
            // Merge the sorted halves
            merge(arr, left, middle, right, population);
        }
    }
}



class HeapSort {
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapifyFirstObj(int heapSize, int i, Point population[], int Q[])
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
         
        // If left child is larger than root
        if (l < heapSize) {
            if(population[Q[l]].isSmall(population[Q[largest]]) == -1) {
                largest = l;
            }
        }
            
        // If right child is larger than largest so far
        if (r < heapSize) {
            if(population[Q[r]].isSmall(population[Q[largest]]) == -1) {
                largest = r;
            }
        }
        
        // If largest is not root
        if (largest != i) {
            int swap = Q[i];
            Q[i] = Q[largest];
            Q[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapifyFirstObj(heapSize, largest, population, Q);
        }
    }
    
    public int[] preSort(Point population[]) {
        int n = population.length;
        int[] Q = new int[n];
        for(int i = 0; i < n; i++) {
            Q[i] = population[i].getId();
        }
        
        /*-- Sort based on first objective --*/
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyFirstObj(n, i, population, Q);
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--) {
            // Move current root to end
            int temp = Q[0];
            Q[0] = Q[i];
            Q[i] = temp;
            
            // call max heapify on the reduced heap
            heapifyFirstObj(i, 0, population, Q);
        }
        /*-- Sort based on first objective --*/
        return Q;
    }
    
    
    public void print(Point population[]) {
        for(int i = 0; i < population.length; i++) {
            System.out.println(population[i]);
        }
    }
}


class Helper {
    public void sortFNDS(Point population[]) {
        System.out.println("******************************* FNDS *******************************");
        Global.setFrontsFNDS = new LinkedList<>(); 
        Global.domCompFNDS = 0;
        Global.timeFNDS = 0;
        Global.noFront = 0;
        
        long startTime = System.nanoTime();
        
        /* Store the dominated points by a particular point */
        LinkedList<Integer>[] ArrSp = new LinkedList[population.length];
        for(int p = 0; p < population.length; p++) {
            ArrSp[p] = new LinkedList();
        }
        
        /* Store the domination count of a particular point */
        int[] ArrNp = new int[population.length];
        
        LinkedList<Integer> currFront = new LinkedList();
        for(int p = 0; p < population.length; p++) {
            /* Dominated points by p-th solution */
            LinkedList<Integer> Sp = new LinkedList();
            /* Domination count of p-th solution */
            int np = 0;
            for(int q = 0; q < population.length; q++) {
                if(p != q) {
                    int dom = population[p].dominanceRelationship1(population[q]);  
                    Global.domCompFNDS++;
                    if(dom == 1) {
                        ArrSp[p].add(population[q].getId());
                    } else if(dom == -1) {
                        ArrNp[p] = ArrNp[p] + 1;
                    }
                }
            }
            if(ArrNp[p] == 0) {
                currFront.add(population[p].getId());
            }   
        }
        Global.setFrontsFNDS.add(new LinkedList(currFront));
        Global.noFront++;
        
        int i = 0;
        while(!currFront.isEmpty()) {
            LinkedList<Integer> Q = new LinkedList();
            for(int p: currFront) {
                for(int q: ArrSp[p]) {
                    ArrNp[q] = ArrNp[q] - 1;
                    if(ArrNp[q] == 0) {
                        Q.add(q);
                    }
                }
            }
            Global.setFrontsFNDS.add(new LinkedList(Q));
            Global.noFront++;
            currFront = new LinkedList();
            currFront.addAll(Q);
        }
        Global.setFrontsFNDS.removeLast();
        Global.noFront--;
        
        long endTime = System.nanoTime();
        Global.timeFNDS = endTime - startTime;
 
        /*for(LinkedList<Integer> front: Global.setFrontsFNDS) {
            System.out.println("Front size = " + front.size());
            for(Integer point: front)
                System.out.print(point + ", ");
            System.out.println();
        }
        System.out.println("domComp = " + Global.domCompFNDS);*/
    }
    
    
    public void sortDS(Point population[]) {
        System.out.println("******************************* DS *******************************");
        Global.setFrontsDS = new LinkedList<>(); 
        Global.domCompDS = 0;
        Global.timeDS = 0;
        Global.noFront = 0;
        
        long startTime = System.nanoTime();
        
        int x = 0;
        int f = 0;
        boolean[] isSorted = new boolean[population.length];
        
        while(f < population.length) { 
            boolean[] D = new boolean[population.length];
            LinkedList<Integer> currFront = new LinkedList();
            for(int i = 0; i < population.length; i++) {
                if(!D[i] && !isSorted[i]) {
                    for(int j = i+1; j < population.length; j++) {
                        if(!D[j] && !isSorted[j]) {
                            int dom = population[i].dominanceRelationship1(population[j]);  
                            Global.domCompDS++;
                            if(dom == 1) { // i dominates j
                                D[j] = true;
                            } else if (dom == -1) { // j dominates i
                                D[i] = true;
                                break;
                            }
                        }
                    }
                    if(!D[i]) {
                        currFront.add(population[i].getId());
                        isSorted[i] = true;
                        f++;
                    }
                } 
            }
            Global.setFrontsDS.add(new LinkedList(currFront));
            Global.noFront++;
        }
        
        long endTime = System.nanoTime();
        Global.timeDS = endTime - startTime;
        
        /*for(LinkedList<Integer> front: Global.setFrontsDS) {
            System.out.println("Front size = " + front.size());
            for(Integer point: front)
                System.out.print(point + ", ");
            System.out.println();
        }
        System.out.println("domComp = " + Global.domCompDS);*/
    }
    
    
    public void sortENS(Point population[]) {
        System.out.println("******************************* ENS *******************************");
        Global.setFrontsENS = new LinkedList<>(); 
        Global.domCompENS = 0;
        Global.timeENS = 0;
        Global.noFront = 0;
        
        long startTime = System.nanoTime();
        
        int n = population.length;
        int[] Q0 = new int[n];
        HeapSort hs = new HeapSort();
        Q0 = hs.preSort(population);
        
        /*System.out.println("Sorted solutions based on first objective");
        System.out.println(Arrays.toString(Q0));*/
        for(int i = 0; i < n; i++) {
            ENSSS(Q0[i], population);
        }
        
        long endTime = System.nanoTime();
        Global.timeENS = endTime - startTime;

        /*for(LinkedList<Integer> front: Global.setFrontsENS) {
            System.out.println("Front size = " + front.size());
            for(Integer point: front)
                System.out.print(point + ", ");
            System.out.println();
        }
        System.out.println("domComp = " + Global.domCompENS);*/
    }

    public void ENSSS(int P, Point population[]) {
        boolean isInsertion = false;
        if(Global.setFrontsENS.isEmpty()) {
            LinkedList<Integer> currFront = new LinkedList();
            currFront.add(P);
            Global.setFrontsENS.add(new LinkedList(currFront));
            Global.noFront++;
        } else {
             for(int k = 0; k < Global.setFrontsENS.size(); k++) {
                 int count = 0;
                 for(int i = Global.setFrontsENS.get(k).size()-1; i >= 0; i--) {
                    int dom = population[P].dominanceRelationship1(population[Global.setFrontsENS.get(k).get(i)]);  
                    Global.domCompENS++; 
                    if(dom == -1) {
                          break;
                     } else {
                         count++;
                     }   
                }
                if(count == Global.setFrontsENS.get(k).size()) {
                    //Insert solution in kth front
                    Global.setFrontsENS.get(k).add(P);
                    isInsertion = true;
                    break;
                }
                if(isInsertion == true) {
                    break;
                }
             }
             if(isInsertion == false) {
                //Insert solution in (k+1)-th front
                LinkedList<Integer> currFront = new LinkedList();
                currFront.add(P);
                Global.setFrontsENS.add(new LinkedList(currFront));
                Global.noFront++;
            } 
        }    
    }
    
    
    public void sortLONSA(Point population[]) {
        System.out.println("******************************* LONSA *******************************");
        Global.setFrontsLONSA = new LinkedList<>(); 
        Global.domCompLONSA = 0;
        Global.timeLONSA = 0;
        Global.noFront = 0;
        
        long startTime = System.nanoTime();
        
        int n = population.length;
        
        int[] array_x = new int[n];
        int[] array_y = new int[n];
        int[] index_array_x = new int[n];
        int[] index_array_y = new int[n];
        
        for(int i = 0; i < n ; i++) {
            population[i].setLabel(1);
        }
        
        MergeSort ms = new MergeSort();
        array_x = ms.sortFirstObjective1(population);
        array_y = ms.sortSecondObjective1(population);
        
        for(int i = 0; i < n; i++) {
            index_array_x[array_x[i]] = i;
            index_array_y[array_y[i]] = i;
        }
        /*System.out.println("array_x: " + Arrays.toString(array_x));
        System.out.println("index_array_x: " + Arrays.toString(index_array_x));
        System.out.println("array_y: " + Arrays.toString(array_y));
        System.out.println("index_array_y: " + Arrays.toString(index_array_y));*/
        
        int remainRankedPoints = n;
        int p, pos_x, pos_y;
        
        while(remainRankedPoints != 0) { 
            for(int i = 0; i < array_x.length; i++) {
                p = array_x[i];
                if(population[p].getLabel() == 1) {
                    population[p].setLabel(2); 
                    pos_y = index_array_y[p]+1;
                    while(pos_y < array_y.length) {
                        if(population[array_y[pos_y]].getLabel() != 3) {
                            int dom = population[p].dominanceRelationship(population[array_y[pos_y]]);
                            Global.domCompLONSA++;
                            if(dom == 1) {
                                population[array_y[pos_y]].setLabel(3);
                                pos_x = index_array_x[array_y[pos_y]];
                                population[array_x[pos_x]].setLabel(3);
                            } else if(dom == -1) {
                                pos_y = index_array_y[p];
                                population[array_y[pos_y]].setLabel(3);
                                pos_x = index_array_x[p];
                                population[array_x[pos_x]].setLabel(3);
                                break;
                            }
                        }
                        pos_y = pos_y + 1;
                    }
                }
            }
            LinkedList<Integer> currFront = new LinkedList();
            for(int i = 0; i < array_x.length; i++) {
                p = array_x[i];
                if(population[p].getLabel() == 2) {
                    currFront.add(p);
                    remainRankedPoints--;
                } else{
                    population[p].setLabel(1);
                }
            }
            Global.setFrontsLONSA.add(new LinkedList(currFront));
            Global.noFront++;
            
            int[] array_Ux = new int[remainRankedPoints];
            int[] array_Uy = new int[remainRankedPoints];
            int index_x = 0;
            int index_y = 0;
            for(int i = 0; i < array_x.length; i++) {
                int px = array_x[i];
                int py = array_y[i];
                if(population[px].getLabel() != 2) {
                    array_Ux[index_x] = px;
                    index_array_x[px] = index_x;
                    index_x++;
                }
                if(population[py].getLabel() != 2) {
                    array_Uy[index_y] = py;
                    index_array_y[py] = index_y;
                    index_y++;
                }
            }
            array_x = new int[remainRankedPoints];
            array_y = new int[remainRankedPoints];
            array_x = array_Ux;
            array_y = array_Uy;
        }
        long endTime = System.nanoTime();
        Global.timeLONSA = endTime - startTime;
 
        /*for(LinkedList<Integer> front: Global.setFrontsLONSA) {
            System.out.println("Front size = " + front.size());
            for(Integer point: front)
               System.out.print(point + ", ");
            System.out.println();
        }
        System.out.println("domComp = " + Global.domCompLONSA);*/
    }

    public void sortmLONSA(Point population[]) {
        System.out.println("******************************* mLONSA *******************************");
        Global.setFrontsmLONSA = new LinkedList<>(); 
        Global.domCompmLONSA = 0;
        Global.timemLONSA = 0;
        Global.noFront = 0;
        
        long startTime = System.nanoTime();
        
        int n = population.length;
        
        int[] array_x = new int[n];
        int[] array_y = new int[n];
        int[] index_array_x = new int[n];
        int[] index_array_y = new int[n];

        for(int i = 0; i < n ; i++) {
            population[i].setLabel(1);
        }
        
        MergeSort ms = new MergeSort();
        array_x = ms.sortFirstObjective(population);
        for(int i = 0; i < n; i++) {
            index_array_x[array_x[i]] = i;
        }
        array_y = ms.sortSecondObjective(population, index_array_x);
        for(int i = 0; i < n; i++) {
            index_array_y[array_y[i]] = i;
        }
        
        /*System.out.println("array_x: " + Arrays.toString(array_x));
        System.out.println("index_array_x: " + Arrays.toString(index_array_x));
        System.out.println("array_y: " + Arrays.toString(array_y));
        System.out.println("index_array_y: " + Arrays.toString(index_array_y));*/
        
        int dComp = 0;
        
        int remainRankedPoints = n;
        int p, pos_x, pos_y;
        
        while(remainRankedPoints != 0) { 
            for(int i = 0; i < array_x.length; i++) {
                p = array_x[i];
                if(population[p].getLabel() == 1) {
                    population[p].setLabel(2); 
                    pos_y = index_array_y[p]+1;
                    while(pos_y < array_y.length) {
                        if(population[array_y[pos_y]].getLabel() != 3) {
                            int dom = population[p].dominanceRelationship(population[array_y[pos_y]]);
                            Global.domCompmLONSA++;
                            if(dom == 1) {
                                population[array_y[pos_y]].setLabel(3);
                            } 
                        }
                        pos_y = pos_y + 1;
                    }
                }
            }
            LinkedList<Integer> currFront = new LinkedList();
            for(int i = 0; i < array_x.length; i++) {
                p = array_x[i];
                if(population[p].getLabel() == 2) {
                    currFront.add(p);
                    remainRankedPoints--;
                } else{
                    population[p].setLabel(1);
                }
            }
            Global.setFrontsmLONSA.add(new LinkedList(currFront));
            Global.noFront++;
            
            int[] array_Ux = new int[remainRankedPoints]; 
            int[] array_Uy = new int[remainRankedPoints];
            int index_x = 0;
            int index_y = 0;
            for(int i = 0; i < array_x.length; i++) {
                int px = array_x[i];
                int py = array_y[i];
                if(population[px].getLabel() != 2) {
                    array_Ux[index_x] = px;
                    index_array_x[px] = index_x;
                    index_x++;
                }
                if(population[py].getLabel() != 2) {
                    array_Uy[index_y] = py;
                    index_array_y[py] = index_y;
                    index_y++;
                }
            }
            array_x = new int[remainRankedPoints];
            array_y = new int[remainRankedPoints];
            array_x = array_Ux;
            array_y = array_Uy;
        }
        long endTime = System.nanoTime();
        Global.timemLONSA = endTime - startTime;
        
        /*for(LinkedList<Integer> front: Global.setFrontsmLONSA) {
            System.out.println("Front size = " + front.size());
            for(Integer point: front)
                System.out.print(point + ", ");
            System.out.println();
        }
        System.out.println("domComp = " + Global.domCompmLONSA);*/
    }
}


class Point {
    private int id;
    private int label;
    private double[] objectives;
              
    public Point () {
        
    }
    
    public Point(int noObjectives) {
        this.objectives = new double[noObjectives];
    }
    
    public Point(Point p) {
        this.id = p.id;
        this.label = p.label;
        this.objectives = new double[p.objectives.length];
        for(int i = 0; i < p.objectives.length; i++) {
            this.objectives[i] = p.objectives[i];
        }
    }
        
    public Point(int id, int label, double[] objectives) {
        this.id = id;
        this.label = label;
        this.objectives = new double[objectives.length];
        for(int i = 0; i < objectives.length; i++) {
            this.objectives[i] = objectives[i];
        }   
    }

    public int getId() {
        return this.id;
    }

    public int getLabel() {
        return label;
    }

    public double[] getObjectives() {
        return this.objectives;
    }
    
    public double getObjective(int index) {
        return this.objectives[index];
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public void setObjectives(double[] objectives) {
        this.objectives = new double[objectives.length];
        for(int i = 0; i < objectives.length; i++) {
            this.objectives[i] = objectives[i];
        }
    }
    
    public void setObjective(double objective, int index) {
        this.objectives[index] = objective;
    }

    public int noObjectives(){
        return this.objectives.length;
    }

    @Override
    public String toString() {
        return "Point{" + "id=" + this.id + ", label=" + this.label + ", objectives=" + Arrays.toString(this.objectives) + '}';
    }
    
    /* Used for pre-sorting as in ENS
     * 1: First point is having small value for a objctive 
      -1: Second point is having small value for a objctive 
       0: Same */
    public int isSmall(Point p) {
        int noObjectives = p.getObjectives().length;
        for(int i = 0; i < noObjectives; i++) {
            if(this.objectives[i] < p.objectives[i]) {
                return 1;
            } else if (this.objectives[i] > p.objectives[i]) {
                return -1;
            }
        }
        return 0;
    }
    
    /* Used for pre-sorting as in BOS
     * 1: First solution is having small value for a objctive function 
      -1: Second solution is having small value for a objctive function */
    public int isSmall(Point sol, int[] Q0Order, int m) {
        if(this.objectives[m] < sol.objectives[m]) {
            return 1;
        } else if(this.objectives[m] > sol.objectives[m]) {
            return -1;
        } else {
            if(Q0Order[this.id] < Q0Order[sol.id]) {
                return 1;
            } else {
                return -1;
            }
        }
    }
    
    /* 1: objectives dominates point 
      -1: point dominates objectives
       0: objectives and point is non-dominting */
    public int dominanceRelationship(Point P) {
        boolean flag1 = false;
        boolean flag2 = false;
        int noObjectives = P.objectives.length;
        for(int i = 0; i < noObjectives; i++) {
            if(this.objectives[i] < P.objectives[i]) {
                flag1 = true;
            } else if(this.objectives[i] > P.objectives[i]) {
                flag2 = true;
            }
        }
        if(flag1 == true && flag2 == false) {
            return 1;
        } else if(flag1 == false && flag2 == true) {
            return -1;
        } else {
            /*--  but in this case non-dominting --*/
            return 0;
        }
    } 
    

    
    /* 1: objectives dominates point 
      -1: point dominates objectives
       0: objectives and point is non-dominting */
    public int dominanceRelationship1(Point P) {
        boolean flag1 = false;
        boolean flag2 = false;
        int noObjectives = P.objectives.length;
        for(int i = 0; i < noObjectives; i++) {
            if(this.objectives[i] < P.objectives[i]) {
                if(flag2) 
                    return 0;
                if(!flag1) 
                    flag1 = true;
            } else if(this.objectives[i] > P.objectives[i]) {
                if(flag1) 
                    return 0;
                if(!flag2) 
                    flag2 = true;
            }
        }
        if(flag1 == true) {
            return 1;
        } else if(flag2 == true) {
            return -1;
        } else {
            /*--  but in this case non-dominting --*/
            return 0;
        }
    } 
    
    
    /* 1: objectives dominates point 
      -1: point dominates objectives
       0: objectives and point is non-dominting */
    public int dominates(Point P) {
        boolean flag1 = false;
        boolean flag2 = false;
        int noObjectives = P.objectives.length;
        for(int i = 0; i < noObjectives; i++) {
            if(this.objectives[i] < P.objectives[i]) {
                flag1 = true;
            } else if(this.objectives[i] > P.objectives[i]) {
                flag2 = true;
            }
        }
        if(flag1 == true && flag2 == false) {
            return 1;
        } else if(flag1 == false && flag2 == true) {
            return -1;
        } else {
            /*--  but in this case non-dominting --*/
            return 0;
        }
    } 

    /* Used in T-ENS
     * 1: First solution is having small/equal value for a objctive function 
      -1: Second solution is having small value for a objctive function */
    public int isSmallorEqual(Point P, int m) {
        if(this.objectives[m] <= P.objectives[m]) {
            return 1;
        } else {
            return -1;
        } 
    }
    
    /* Used for pre-sorting in T-ENS
     * 1: First solution is having small value for a objctive function 
      -1: Second solution is having small value for a objctive function 
       0: Same */
    public int isSmallReverse(Point P) {
        int noObjectives = P.getObjectives().length;
        for(int i = noObjectives-1; i >=0; i--) {
            if(this.objectives[i] < P.objectives[i]) {
                return 1;
            } else if (this.objectives[i] > P.objectives[i]) {
                return -1;
            }
        }
        return 0;
    }
}


class Process_Dataset {
    public void processCloudDataset(String inputPath_ProcessDataset_Cloud,
            String inputPath_ProcessResult_Cloud) throws IOException {
        String folderPathOut = inputPath_ProcessDataset_Cloud;
        File folderOut = new File(folderPathOut);
        File[] listOfFoldersOut = folderOut.listFiles();

        String writeFolderPath = inputPath_ProcessResult_Cloud;
        
        for (File fileOut : listOfFoldersOut) {
            if (fileOut.isDirectory()) {
                String folderPathIn = folderPathOut + fileOut.getName() + "\\";
                File folderIn = new File(folderPathIn);
                File[] listOfFoldersIn = folderIn.listFiles();
                
                String writeFileName = fileOut.getName() + ".txt";
                String writeFilePath = writeFolderPath + writeFileName;
                System.out.println("writeFileName = " + writeFileName);
                System.out.println("writeFilePath = " + writeFilePath);
                BufferedWriter fwriter = new BufferedWriter(new FileWriter(writeFilePath));

                for (File file : listOfFoldersIn) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        String filePath = folderPathIn + fileName + "\\";
                        System.out.println(fileName);

                        int noPoint;
                        int noObj;
                        String noPointString = fileName.substring(0, fileName.indexOf("_"));
                        
                        int first = fileName.indexOf("_");
                        int second = fileName.indexOf("_", first + 1);
                        int third = fileName.indexOf("_", second + 1);
                        String noObjString = fileName.substring(second+1,third);
                        
                        noPoint = Integer.parseInt(noPointString);
                        noObj = Integer.parseInt(noObjString);
                        processCloud(noPoint, noObj, filePath, fwriter); 
                    }
                } 
                fwriter.close();
            }
        }
    }
    
    public void processCloud(int noPoint, int noObj, String filePath, BufferedWriter fwriter) throws FileNotFoundException, IOException {
        Point[] population = new Point[noPoint];
        for(int i = 0; i < noPoint; i++) {
            population[i] = new Point(noObj);
        }
        int id = 0;
       
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(filePath));
        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {
            String[] temp = sCurrentLine.trim().split(" ");
            Point point = new Point(noObj);
            for(int i = 0; i < temp.length; i++) {
                point.setObjective(Double.parseDouble(temp[i]), i);
            }
            point.setId(id);
            population[id] = new Point(point); 
            id++;
        }  
        
        Helper h = new Helper();
        
        h.sortFNDS(population);
        String strFNDS = noPoint + " " + noObj + " " + Global.domCompFNDS + " " + Global.timeFNDS + " " + Global.noFront;
        fwriter.write(strFNDS);
        fwriter.newLine();
        
        h.sortDS(population); 
        String strDS = noPoint + " " + noObj + " " + Global.domCompDS + " " + Global.timeDS + " " + Global.noFront;
        fwriter.write(strDS);
        fwriter.newLine();
        
        h.sortENS(population); 
        String strENS = noPoint + " " + noObj + " " + Global.domCompENS + " " + Global.timeENS + " " + Global.noFront;
        fwriter.write(strENS);
        fwriter.newLine();
       
        h.sortLONSA(population);
        String strLONSA = noPoint + " " + noObj + " " + Global.domCompLONSA + " " + Global.timeLONSA + " " + Global.noFront;
        fwriter.write(strLONSA);
        fwriter.newLine();

        h.sortmLONSA(population);
        String strmLONSA = noPoint + " " + noObj + " " + Global.domCompmLONSA + " " + Global.timemLONSA + " " + Global.noFront;
        fwriter.write(strmLONSA);
        fwriter.newLine();
    }
    
    
    public void processFixedFrontDataset(String inputPath_ProcessDataset_Fixed_Front,
            String inputPath_ProcessResult_Fixed_Front) throws IOException {
        String folderPathOut = inputPath_ProcessDataset_Fixed_Front;
        File folderOut = new File(folderPathOut);
        File[] listOfFoldersOut = folderOut.listFiles();

        String writeFolderPath = inputPath_ProcessResult_Fixed_Front;
        
        for (File fileOut : listOfFoldersOut) {
            if (fileOut.isDirectory()) {
                String folderPathIn = folderPathOut + fileOut.getName() + "\\";
                File folderIn = new File(folderPathIn);
                File[] listOfFoldersIn = folderIn.listFiles();
                
                String writeFileName = fileOut.getName() + ".txt";
                String writeFilePath = writeFolderPath + writeFileName;
                BufferedWriter fwriter = new BufferedWriter(new FileWriter(writeFilePath));
                
                for (File file : listOfFoldersIn) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        String filePath = folderPathIn + fileName + "\\";
                        System.out.println(fileName);

                        int noPoint;
                        int noFront;
                        int noObj;
                        String noPointString = fileName.substring(0, fileName.indexOf("_"));
                        
                        int first = fileName.indexOf("_");
                        int second = fileName.indexOf("_", first + 1);
                        int third = fileName.indexOf("_", second + 1);
                        int fourth = fileName.indexOf("_", third + 1);
                        int fifth = fileName.indexOf("_", fourth + 1);
                        String noFrontString = fileName.substring(second+1,third);
                        String noObjString = fileName.substring(fourth+1,fifth);
                        
                        noPoint = Integer.parseInt(noPointString);
                        noFront = Integer.parseInt(noFrontString);
                        noObj = Integer.parseInt(noObjString);
                        
                        processFixedFront(noPoint, noObj, noFront, filePath, fwriter);
                    }
                } 
                fwriter.close();
            }
        }
    }
    
    public static void processFixedFront(int noPoint, int noObj, int noFront, String filePath, BufferedWriter fwriter) throws FileNotFoundException, IOException {
        Point[] population = new Point[noPoint];
        for(int i = 0; i < noPoint; i++) {
            population[i] = new Point(noObj);
        }
        int id = 0;
       
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(filePath));
        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {
            String[] temp = sCurrentLine.trim().split(" ");
            Point point = new Point(noObj);
            for(int i = 0; i < temp.length; i++) {
                point.setObjective(Double.parseDouble(temp[i]), i);
            }
            point.setId(id);
            population[id] = new Point(point); 
            id++;
        }  
        
        Helper h = new Helper();
        
        h.sortFNDS(population);
        String strFNDS = noPoint + " " + noObj + " " + Global.domCompFNDS + " " + Global.timeFNDS + " " + Global.noFront;
        fwriter.write(strFNDS);
        fwriter.newLine();
        
        h.sortDS(population); 
        String strDS = noPoint + " " + noObj + " " + Global.domCompDS + " " + Global.timeDS + " " + Global.noFront;
        fwriter.write(strDS);
        fwriter.newLine();
        
        h.sortENS(population); 
        String strENS = noPoint + " " + noObj + " " + Global.domCompENS + " " + Global.timeENS + " " + Global.noFront;
        fwriter.write(strENS);
        fwriter.newLine();
        
        h.sortLONSA(population);
        String strLONSA = noPoint + " " + noObj + " " + Global.domCompLONSA + " " + Global.timeLONSA + " " + Global.noFront;
        fwriter.write(strLONSA);
        fwriter.newLine();

        h.sortmLONSA(population);
        String strmLONSA = noPoint + " " + noObj + " " + Global.domCompmLONSA + " " + Global.timemLONSA + " " + Global.noFront;
        fwriter.write(strmLONSA);
        fwriter.newLine();
    }
    
    
    
    public void processWorstData(String inputPath_ProcessDataset_Worst,
            String inputPath_ProcessResult_Worst) throws IOException {
        String folderPathOut = inputPath_ProcessDataset_Worst;
        File folderOut = new File(folderPathOut);
        File[] listOfFoldersOut = folderOut.listFiles();

        String writeFolderPath = inputPath_ProcessResult_Worst;
        
        for (File fileOut : listOfFoldersOut) {
            if (fileOut.isDirectory()) {
                String folderPathIn = folderPathOut + fileOut.getName() + "\\";
                File folderIn = new File(folderPathIn);
                File[] listOfFoldersIn = folderIn.listFiles();
                
                String writeFileName = fileOut.getName() + ".txt";
                String writeFilePath = writeFolderPath + writeFileName;
                System.out.println("writeFileName = " + writeFileName);
                System.out.println("writeFilePath = " + writeFilePath);
                BufferedWriter fwriter = new BufferedWriter(new FileWriter(writeFilePath));

                for (File file : listOfFoldersIn) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        String filePath = folderPathIn + fileName + "\\";
                        System.out.println(fileName);

                        int noPoint;
                        int noObj;
                        String noPointString = fileName.substring(0, fileName.indexOf("_"));
                        
                        int first = fileName.indexOf("_");
                        int second = fileName.indexOf("_", first + 1);
                        int third = fileName.indexOf("_", second + 1);
                        String noObjString = fileName.substring(second+1,third);
                        
                        noPoint = Integer.parseInt(noPointString);
                        noObj = Integer.parseInt(noObjString);
                        processCloud(noPoint, noObj, filePath, fwriter); 
                    }
                } 
                fwriter.close();
            }
        }
    }
    
    public void processWorst(int noPoint, int noObj, String filePath, BufferedWriter fwriter) throws FileNotFoundException, IOException {
        Point[] population = new Point[noPoint];
        for(int i = 0; i < noPoint; i++) {
            population[i] = new Point(noObj);
        }
        int id = 0;
       
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(filePath));
        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {
            String[] temp = sCurrentLine.trim().split(" ");
            Point point = new Point(noObj);
            for(int i = 0; i < temp.length; i++) {
                point.setObjective(Double.parseDouble(temp[i]), i);
            }
            point.setId(id);
            population[id] = new Point(point); 
            id++;
        }  
        
        Helper h = new Helper();
        
        h.sortFNDS(population);
        String strFNDS = noPoint + " " + noObj + " " + Global.domCompFNDS + " " + Global.timeFNDS + " " + Global.noFront;
        fwriter.write(strFNDS);
        fwriter.newLine();
        
        h.sortDS(population); 
        String strDS = noPoint + " " + noObj + " " + Global.domCompDS + " " + Global.timeDS + " " + Global.noFront;
        fwriter.write(strDS);
        fwriter.newLine();
        
        h.sortENS(population); 
        String strENS = noPoint + " " + noObj + " " + Global.domCompENS + " " + Global.timeENS + " " + Global.noFront;
        fwriter.write(strENS);
        fwriter.newLine();
        
        h.sortLONSA(population);
        String strLONSA = noPoint + " " + noObj + " " + Global.domCompLONSA + " " + Global.timeLONSA + " " + Global.noFront;
        fwriter.write(strLONSA);
        fwriter.newLine();

        h.sortmLONSA(population);
        String strmLONSA = noPoint + " " + noObj + " " + Global.domCompmLONSA + " " + Global.timemLONSA + " " + Global.noFront;
        fwriter.write(strmLONSA);
        fwriter.newLine();
    }
    
}



class Process_Result {
    public void CloudResult(String inputPath_ProcessResult_Cloud) throws IOException {
        String folderPath = inputPath_ProcessResult_Cloud;
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();
        
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String fileName = file.getName();
                String filePath = folderPath + fileName + "\\";
                System.out.println();
                System.out.println(fileName);
                
                int noObj;
                String noObjString = fileName.substring(fileName.indexOf("_")+1, fileName.indexOf("."));
                noObj = Integer.parseInt(noObjString);      
                
                ArrayList<Cloud_Data> listFNDS = new ArrayList<>();
                ArrayList<Cloud_Data> listDS = new ArrayList<>();
                ArrayList<Cloud_Data> listENS = new ArrayList<>();
                ArrayList<Cloud_Data> listLONSA = new ArrayList<>();
                ArrayList<Cloud_Data> listmLONSA = new ArrayList<>();
                
                int i = 1;
                BufferedReader br = null;
                br = new BufferedReader(new FileReader(filePath));
                String sCurrentLine;
                while ((sCurrentLine = br.readLine()) != null) {
                    String[] temp = sCurrentLine.trim().split(" ");
                    int noPoint = Integer.parseInt(temp[0]);
                    noObj = Integer.parseInt(temp[1]);
                    int domComp = Integer.parseInt(temp[2]);
                    long time = Long.parseLong(temp[3]);
                    int noFront = Integer.parseInt(temp[4]);

                    Cloud_Data cd = new Cloud_Data(noPoint, noObj, domComp, time, noFront);

                    if(i%5 == 1) { 
                        listFNDS.add(new Cloud_Data(cd));
                    } else if (i%5 == 2) { 
                        listDS.add(new Cloud_Data(cd));
                    } else if (i%5 == 3) {
                        listENS.add(new Cloud_Data(cd));
                    } else if (i%5 == 4) {
                        listLONSA.add(new Cloud_Data(cd));
                    } else {
                        listmLONSA.add(new Cloud_Data(cd));
                    }
                    i++;
                }

                Collections.sort(listFNDS, Cloud_Data.noPointComparator);
                Collections.sort(listDS, Cloud_Data.noPointComparator);
                Collections.sort(listENS, Cloud_Data.noPointComparator);
                Collections.sort(listLONSA, Cloud_Data.noPointComparator);
                Collections.sort(listmLONSA, Cloud_Data.noPointComparator);

                HelpCloudResult(listFNDS, listDS, listENS, listLONSA, listmLONSA);
            }   
        }
    }
    
    
    public void HelpCloudResult(ArrayList<Cloud_Data> listFNDS, ArrayList<Cloud_Data> listDS,
            ArrayList<Cloud_Data> listENS, ArrayList<Cloud_Data> listLONSA, ArrayList<Cloud_Data> listmLONSA){
        System.out.println(listFNDS);
        System.out.println(listDS);
        System.out.println(listENS);
        System.out.println(listLONSA);
        System.out.println(listmLONSA);

        String strFNDS = "";
        String strDS = "";
        String strENS = "";
        String strLONSA = "";
        String strmLONSA = "";
        for(int k = 0; k < listFNDS.size(); k++) {
            strFNDS = strFNDS + listFNDS.get(k).getDomComp() + ", ";
            strDS = strDS + listDS.get(k).getDomComp() + ", ";
            strENS = strENS + listENS.get(k).getDomComp() + ", ";
            strLONSA = strLONSA + listLONSA.get(k).getDomComp() + ", ";
            strmLONSA = strmLONSA + listmLONSA.get(k).getDomComp() + ", ";
        }
        System.out.println("dComp_FNDS = " + strFNDS);
        System.out.println("dComp_DS = " + strDS);
        System.out.println("dComp_ENS = " + strENS);
        System.out.println("dComp_LONSA = " + strLONSA);
        System.out.println("dComp_mLONSA = " + strmLONSA);
        
        /*----------------------------------------------------------------------------------*/
        strFNDS = "";
        strDS = "";
        strENS = "";
        strLONSA = "";
        strmLONSA = "";
        for(int k = 0; k < listFNDS.size(); k++) {
            strFNDS = strFNDS + listFNDS.get(k).getTime() + ", ";
            strDS = strDS + listDS.get(k).getTime() + ", ";
            strENS = strENS + listENS.get(k).getTime() + ", ";
            strLONSA = strLONSA + listLONSA.get(k).getTime() + ", ";
            strmLONSA = strmLONSA + listmLONSA.get(k).getTime() + ", ";
        }
        System.out.println("time_FNDS = " + strFNDS);
        System.out.println("time_DS = " + strDS);
        System.out.println("time_ENS = " + strENS);
        System.out.println("time_LONSA = " + strLONSA);
        System.out.println("time_mLONSA = " + strmLONSA);
    }
    
    
    public void FixedFrontResult(String inputPath_ProcessResult_Fixed_Front) throws IOException {
        String folderPath = inputPath_ProcessResult_Fixed_Front;
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();
        
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String fileName = file.getName();
                String filePath = folderPath + fileName + "\\";
                System.out.println(fileName);
                
                int noObj;
                String noObjString = fileName.substring(fileName.indexOf("_")+1, fileName.indexOf("."));
                noObj = Integer.parseInt(noObjString);      

                ArrayList<FixedFront_Data> listFNDS = new ArrayList<>();
                ArrayList<FixedFront_Data> listDS = new ArrayList<>();
                ArrayList<FixedFront_Data> listENS = new ArrayList<>();
                ArrayList<FixedFront_Data> listLONSA = new ArrayList<>();
                ArrayList<FixedFront_Data> listmLONSA = new ArrayList<>();
                
                int i = 1;
                BufferedReader br = null;
                br = new BufferedReader(new FileReader(filePath));
                String sCurrentLine;
                while ((sCurrentLine = br.readLine()) != null) {
                    String[] temp = sCurrentLine.trim().split(" ");
                    int noPoint = Integer.parseInt(temp[0]);
                    noObj = Integer.parseInt(temp[1]);
                    int domComp = Integer.parseInt(temp[2]);
                    long time = Long.parseLong(temp[3]);
                    int noFront = Integer.parseInt(temp[4]);

                    FixedFront_Data fd = new FixedFront_Data(noPoint, noObj, domComp, time, noFront);

                    if(i%5 == 1) { 
                        listFNDS.add(new FixedFront_Data(fd));
                    } else if (i%5 == 2) { 
                        listDS.add(new FixedFront_Data(fd));
                    } else if (i%5 == 3) {
                        listENS.add(new FixedFront_Data(fd));
                    } else if (i%5 == 4) {
                        listLONSA.add(new FixedFront_Data(fd));
                    } else {
                        listmLONSA.add(new FixedFront_Data(fd));
                    }
                    i++;
                }

                Collections.sort(listFNDS, FixedFront_Data.noFrontComparator);
                Collections.sort(listDS, FixedFront_Data.noFrontComparator);
                Collections.sort(listENS, FixedFront_Data.noFrontComparator);
                Collections.sort(listLONSA, FixedFront_Data.noFrontComparator);
                Collections.sort(listmLONSA, FixedFront_Data.noFrontComparator);

                HelpFixedFrontResult(listFNDS, listDS, listENS, listLONSA, listmLONSA);
            }
        }
    }
    
    
    public void HelpFixedFrontResult(ArrayList<FixedFront_Data> listFNDS, 
            ArrayList<FixedFront_Data> listDS,
            ArrayList<FixedFront_Data> listENS, 
            ArrayList<FixedFront_Data> listLONSA, 
            ArrayList<FixedFront_Data> listmLONSA){
        System.out.println(listFNDS);
        System.out.println(listDS);
        System.out.println(listENS);
        System.out.println(listLONSA);
        System.out.println(listmLONSA);

        String strFNDS = "";
        String strDS = "";
        String strENS = "";
        String strLONSA = "";
        String strmLONSA = "";
        for(int k = 0; k < listFNDS.size(); k++) {
            strFNDS = strFNDS + listFNDS.get(k).getDomComp() + ", ";
            strDS = strDS + listDS.get(k).getDomComp() + ", ";
            strENS = strENS + listENS.get(k).getDomComp() + ", ";
            strLONSA = strLONSA + listLONSA.get(k).getDomComp() + ", ";
            strmLONSA = strmLONSA + listmLONSA.get(k).getDomComp() + ", ";
        }
        System.out.println("dComp_FNDS = " + strFNDS);
        System.out.println("dComp_DS = " + strDS);
        System.out.println("dComp_ENS = " + strENS);
        System.out.println("dComp_LONSA = " + strLONSA);
        System.out.println("dComp_mLONSA = " + strmLONSA);
        
        /*----------------------------------------------------------------------------------*/
        strFNDS = "";
        strDS = "";
        strENS = "";
        strLONSA = "";
        strmLONSA = "";
        for(int k = 0; k < listFNDS.size(); k++) {
            strFNDS = strFNDS + listFNDS.get(k).getTime() + ", ";
            strDS = strDS + listDS.get(k).getTime() + ", ";
            strENS = strENS + listENS.get(k).getTime() + ", ";
            strLONSA = strLONSA + listLONSA.get(k).getTime() + ", ";
            strmLONSA = strmLONSA + listmLONSA.get(k).getTime() + ", ";
        }
        System.out.println("time_FNDS = " + strFNDS);
        System.out.println("time_DS = " + strDS);
        System.out.println("time_ENS = " + strENS);
        System.out.println("time_LONSA = " + strLONSA);
        System.out.println("time_mLONSA = " + strmLONSA);
    }
 
    
    
    
    public void WorstResult(String inputPath_ProcessResult_Worst) throws IOException {
        String folderPath = inputPath_ProcessResult_Worst;
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();
        
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String fileName = file.getName();
                String filePath = folderPath + fileName + "\\";
                System.out.println();
                System.out.println(fileName);
                
                int noObj;
                String noObjString = fileName.substring(fileName.indexOf("_")+1, fileName.indexOf("."));
                noObj = Integer.parseInt(noObjString);      
                
                ArrayList<Cloud_Data> listFNDS = new ArrayList<>();
                ArrayList<Cloud_Data> listDS = new ArrayList<>();
                ArrayList<Cloud_Data> listENS = new ArrayList<>();
                ArrayList<Cloud_Data> listLONSA = new ArrayList<>();
                ArrayList<Cloud_Data> listmLONSA = new ArrayList<>();
                
                int i = 1;
                BufferedReader br = null;
                br = new BufferedReader(new FileReader(filePath));
                String sCurrentLine;
                while ((sCurrentLine = br.readLine()) != null) {
                    String[] temp = sCurrentLine.trim().split(" ");
                    int noPoint = Integer.parseInt(temp[0]);
                    noObj = Integer.parseInt(temp[1]);
                    int domComp = Integer.parseInt(temp[2]);
                    long time = Long.parseLong(temp[3]);
                    int noFront = Integer.parseInt(temp[4]);

                    Cloud_Data cd = new Cloud_Data(noPoint, noObj, domComp, time, noFront);

                    if(i%5 == 1) { 
                        listFNDS.add(new Cloud_Data(cd));
                    } else if (i%5 == 2) { 
                        listDS.add(new Cloud_Data(cd));
                    } else if (i%5 == 3) {
                        listENS.add(new Cloud_Data(cd));
                    } else if (i%5 == 4) {
                        listLONSA.add(new Cloud_Data(cd));
                    } else {
                        listmLONSA.add(new Cloud_Data(cd));
                    }
                    i++;
                }

                Collections.sort(listFNDS, Cloud_Data.noPointComparator);
                Collections.sort(listDS, Cloud_Data.noPointComparator);
                Collections.sort(listENS, Cloud_Data.noPointComparator);
                Collections.sort(listLONSA, Cloud_Data.noPointComparator);
                Collections.sort(listmLONSA, Cloud_Data.noPointComparator);

                HelpCloudResult(listFNDS, listDS, listENS, listLONSA, listmLONSA);
            }   
        }
    }
    
    
    public void HelpWorstResult(ArrayList<Cloud_Data> listFNDS, ArrayList<Cloud_Data> listDS,
            ArrayList<Cloud_Data> listENS, ArrayList<Cloud_Data> listLONSA, ArrayList<Cloud_Data> listmLONSA){
        System.out.println(listFNDS);
        System.out.println(listDS);
        System.out.println(listENS);
        System.out.println(listLONSA);
        System.out.println(listmLONSA);

        String strFNDS = "";
        String strDS = "";
        String strENS = "";
        String strLONSA = "";
        String strmLONSA = "";
        for(int k = 0; k < listFNDS.size(); k++) {
            strFNDS = strFNDS + listFNDS.get(k).getDomComp() + ", ";
            strDS = strDS + listDS.get(k).getDomComp() + ", ";
            strENS = strENS + listENS.get(k).getDomComp() + ", ";
            strLONSA = strLONSA + listLONSA.get(k).getDomComp() + ", ";
            strmLONSA = strmLONSA + listmLONSA.get(k).getDomComp() + ", ";
        }
        System.out.println("dComp_FNDS = " + strFNDS);
        System.out.println("dComp_DS = " + strDS);
        System.out.println("dComp_ENS = " + strENS);
        System.out.println("dComp_LONSA = " + strLONSA);
        System.out.println("dComp_mLONSA = " + strmLONSA);
        
        /*----------------------------------------------------------------------------------*/
        strFNDS = "";
        strDS = "";
        strENS = "";
        strLONSA = "";
        strmLONSA = "";
        for(int k = 0; k < listFNDS.size(); k++) {
            strFNDS = strFNDS + listFNDS.get(k).getTime() + ", ";
            strDS = strDS + listDS.get(k).getTime() + ", ";
            strENS = strENS + listENS.get(k).getTime() + ", ";
            strLONSA = strLONSA + listLONSA.get(k).getTime() + ", ";
            strmLONSA = strmLONSA + listmLONSA.get(k).getTime() + ", ";
        }
        System.out.println("time_FNDS = " + strFNDS);
        System.out.println("time_DS = " + strDS);
        System.out.println("time_ENS = " + strENS);
        System.out.println("time_LONSA = " + strLONSA);
        System.out.println("time_mLONSA = " + strmLONSA);
    } 
}
