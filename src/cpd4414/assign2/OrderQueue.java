/*
 * Copyright 2015 Len Payne <len.payne@lambtoncollege.ca>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cpd4414.assign2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
public class OrderQueue {

    Queue<Order> orderQueue = new ArrayDeque<>();
    List<Order> processed = new ArrayList<>();
    List<Order> fulfilled = new ArrayList<>();

    public void add(Order order) throws Exception {
        orderQueue.add(order);
        order.setTimeReceived(new Date());
        if (order.getCustomerId() == "" && order.getCustomerName() == "") {
            throw new Exception("Customer Id and Customer Name is null. Please try again.");
        }

        if (order.getListOfPurchases().isEmpty()) {
            throw new Exception("List of Purchases are empty");
        }
        orderQueue.add(order);
    }

    public void setTimeReceived(Order order) {
        order.setTimeReceived(new Date());
    }

    public void setTimeProcessed(Order order) {
        order.setTimeProcessed(new Date());
    }

    public void orderProcessed(Order order) throws Exception {
        if (order.getTimeReceived() == null) {
            throw new Exception("Order has no time recieved");
        }
        processed.add(order);
        orderQueue.remove(order);
    }

    public Order returnQueue() {
        if (orderQueue.isEmpty()) {
            System.out.println("Never a null moment");
            return null;
        }
        return orderQueue.element();
    }

    public void orderFulfilled(Order order) throws Exception {
        if (order.getTimeReceived() == null) {
            throw new Exception("Order has no time recieved");
        }
        if (order.getTimeProcessed() == null){
            throw new Exception("Order has not time processed");
        }
        fulfilled.add(order);
        processed.remove(order);
    }

}
