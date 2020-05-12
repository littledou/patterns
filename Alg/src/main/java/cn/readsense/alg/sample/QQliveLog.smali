.class public Lcn/readsense/alg/sample/QQliveLog;
.super Ljava/lang/Object;
.source "QQliveLog.java"


# static fields
.field private static sIsDebug:Z

.field private static sProcessName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static logs(Ljava/lang/String;Ljava/lang/String;)Z
    .registers 5
    .param p0, "arg3"    # Ljava/lang/String;
    .param p1, "arg4"    # Ljava/lang/String;

    .prologue
    .line 10
    const/4 v0, 0x1

    .line 12
    .local v0, "next":Z
    if-eqz v0, :cond_c

    .line 13
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v2, ""

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 14
    const/4 v1, 0x1

    .line 16
    :goto_b
    return v1

    :cond_c
    const/4 v1, 0x0

    goto :goto_b
.end method
