# Threads
### 1. Creating an inner class
```java
private class "Classname" extends Thread{

}
```
### 2. Implementing the run method
```java
private class "Classname" extends Thread{
  public void run(){
      //add code to be executed in the thread
  }
}
```
### 3. Instantiating the thread
put this code where you want the thread to start
```java
"Classname" c = new "Classname"();
```
### 4. calling the run method
```java
c.run();
```


