package zad2;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Random;

public class DecryptionSubscriber implements Subscriber {
    public void onSubscribe(Subscription subscription) {
        System.out.println("onSubscribe on " + Thread.currentThread().getName());
        try {
            Thread.sleep(new Random().nextInt(8000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        subscription.request(Long.MAX_VALUE);
    }

    public void onNext(Object o) {
        String key = o.toString();
        System.out.println(key);

    }

    public void onError(Throwable throwable) {
        System.out.println("error");
    }

    public void onComplete() {

    }
}
