int MAXSIZE;

typedef struct{
    int data[MAXSIZE];
    int last;
}SeqList;

SeqList *init_SeqList(){
    SeqList *L;
    L = malloc(sizeof(SeqList));
    L->last=-1;
    return L;
}

int Insert_SeqList(SeqList *L, int i, int x){
    int j;
    if(L->last==MAXSIZE-1){
        printf("full");
        return -1;
    }
    if(i<1||i>L->last+2){
        printf("wrong index");
        return 0;
    }
    for(j = L->last;j >= i-1; j--){
        L->data[j+1] = L->data[j];
    }
    L->data[i-1]=x;
    L->last++;
    return (1);
}

int Delete_SeqList(SeqList *L, int i){
    if(i<1||i>L->last+2){
        printf("wrong index");
        return 0;
    }
    int j;
    for(j = i;j<=L->last;j++){
        L->data[j-1] =L->data[j];
    }
    L->last--;
    return (1);
}

//
void partition(SeqList *L){
    int x = L->data[0];

}

int main(){
    SeqList *L;
    L = init_SeqList();

    return 0;
}
