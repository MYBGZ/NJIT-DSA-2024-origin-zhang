package oy.tol.tra;

/**
 * A generic interface to queue class. Queues work following 
 * the first-in-first-out principle.
 * Students: Implement this interface in a separate <code>QueueImplementation.java</code> file.
 *           No implementation in this file!!
 */
public class QueueImplementation<E> implements QueueInterface<E> {

   private Object [] itemArray;
   private int capacity;
   private int size, front, rear;
   private static final int DEFAULT_QUEUE_SIZE = 10;

   public QueueImplementation() throws QueueAllocationException {
      // TODO: call the constructor with size parameter with default size of 10.
      capacity = DEFAULT_QUEUE_SIZE;
      itemArray = new Object[DEFAULT_QUEUE_SIZE];
   }

   /** TODO: Implement so that
    * - if the size is less than 2, throw StackAllocationException
    * - if the allocation of the array throws with Java exception,
    *   throw StackAllocationException.
    * @param capacity The capacity of the stack.
    * @throws StackAllocationException If cannot allocate room for the internal array.
    */
   public QueueImplementation(int capacity) throws QueueAllocationException {
      if (capacity < 2){
         throw new QueueAllocationException("It cannot be less than 2.");
      }
      this.capacity = capacity;
      itemArray = new Object[capacity];
   }
   
   /**
    * For querying the current capacity of the queue.
    @return The number of elements the queue can currently hold.
    */
   public int capacity(){
    return capacity;
   }
   
   /**
    * Add an element to the queue.
    * @param element The element to add, must not be null.
    * @throws QueueAllocationException If the reallocation for the queue failed in case queue needs reallocation.
    * @throws NullPointerException If the element is null.
    */
   public void enqueue(E element) throws QueueAllocationException, NullPointerException{
    if (element == null){
        throw new NullPointerException("It's null.");
    }
    if (rear + 1 > capacity) {
      int newcapacity = capacity*2;
      Object[] newArray = new Object[newcapacity];
      for (int i = 0; i < size; i++) {
         newArray[i] = itemArray[front +i];
      }
      capacity = newcapacity;
      front = 0;
      rear = size;
      itemArray = newArray;
    }
    itemArray[rear] = element;
    size++;
    rear++;
}

   /**
    * Removes an element from the queue.
    * @return The element from the head of the queue.
    * @throws QueueIsEmptyException If the queue is empty.
    */
   public E dequeue() throws QueueIsEmptyException{
    if(isEmpty()){
        throw new QueueIsEmptyException("It's null.");
    }
    E k = (E) itemArray[front];
    itemArray[front] = null;
    front = (front + 1) % capacity;
    size--;
    return k;
   }

   /**
    * Returns the element at the head of the queue, not removing it from the queue.
    * @return The element in the head of the queue.
    * @throws QueueIsEmptyException If the queue is empty.
    */
   public E element() throws QueueIsEmptyException{
    if(isEmpty()){
        throw new QueueIsEmptyException("It's null.");
    }
    return (E) itemArray[front];
   }

   /**
    * Returns the count of elements currently in the queue.
    * @return Count of elements in the queue.
    */
   public int size(){
    return size;
   }

   /**
    * Can be used to check if the queue is empty.
    * @return True if the queue is empty, false otherwise.
    */
   public boolean isEmpty(){
    return size == 0;
   }

   /**
    * Resets the queue to empty state, removing the objects.
    */
   public void clear(){
      itemArray = new Object[capacity];
      front = 0;
      rear = 0;
      size = 0;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder("[");
      for (int index = 0; index < size; index++) {
         builder.append(itemArray[(front + index) % capacity]);
         if (index < size-1) {
            builder.append(", ");
         }
      }
      builder.append("]");
      return builder.toString();
   }
}

