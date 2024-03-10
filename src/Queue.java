import java.time.LocalDateTime;
import java.util.LinkedList;

public class Queue {
    private LinkedList<Ticket> queue;

    public Queue() {
        this.queue = new LinkedList<>();
    }
    public void offer(Ticket ticket) {
        queue.addLast(ticket);
    }

    public Ticket poll() {
        if(queue.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else {
            return queue.removeFirst();
        }
    }

    public Ticket peek() {
        return queue.peek();
    }

    public static void main(String[] args) throws InterruptedException {
        Queue queue = new Queue();

        for (int i = 1; i < 11; i++) {
            Ticket ticket = new Ticket(i, LocalDateTime.now() + "");
            queue.offer(ticket);
            System.out.println("Issued Ticket " + ticket.ticketNum() + " at " + ticket.timestamp());
            Thread.sleep(1000);
        }

        while (queue.peek() != null) {
            Ticket ticket = queue.poll();
            System.out.println("Processing Ticket " + ticket.ticketNum() + " issued at " + ticket.timestamp());
            Thread.sleep(2000);
        }
    }
}
