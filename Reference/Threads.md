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
put this code with the rest of your base variables
```java
"Classname" c = new "Classname"();
```
### 4. Calling the run method
place this code where you want the thread to run
```java
c.run();
```


