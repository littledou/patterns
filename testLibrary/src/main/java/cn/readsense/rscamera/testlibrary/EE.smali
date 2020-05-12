.class public Lcn/readsense/rscamera/testlibrary/EE;
.super Ljava/lang/Object;
.source "EE.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private pro(Ljava/lang/String;)V
    .registers 4
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 10
    const/4 v0, 0x1

    .line 11
    const/4 v0, 0x1
    .local v0, "next":Z
    if-nez v0, :cond_8

    .line 13
    const-string v1, "doug"

    invoke-static {v1, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 15
    :cond_8
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v1}, Ljava/io/PrintStream;->println()V

    .line 17
    return-void
.end method
