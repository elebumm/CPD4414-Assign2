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

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Queue;

/**
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
public class OrderQueue {
    Queue<Order> orderQueue = new ArrayDeque<>();
    
    public void add(Order order) {
        orderQueue.add(order);
        order.setTimeReceived(new Date());
    }


public String orderCheck(Order order) throws IOException{
    String message = null;
    if (order.getCustomerId() == "" || order.getCustomerName() == ""){
        throw new IOException("Customer Id and Customer Name is null. Please try again.");
    }
    else if (order.getListOfPurchases().isEmpty()){
        throw new IOException("List of purchases is empty. Please add some entries and try again.");
    }
    
    return message;
}

public String nextOrder(Order order) throws IOException{
    String message = null;
    
    
    
    return message;
}
}