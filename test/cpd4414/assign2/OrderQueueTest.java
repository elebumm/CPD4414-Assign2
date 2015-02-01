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

import cpd4414.assign2.OrderQueue;
import cpd4414.assign2.Purchase;
import cpd4414.assign2.Order;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
public class OrderQueueTest {

    public OrderQueueTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testWhenCustomerExistsAndPurchasesExistThenTimeReceivedIsNow() throws Exception {
        OrderQueue orderQueue = new OrderQueue();
        Order order = new Order("CUST00001", "ABC Construction");
        order.addPurchase(new Purchase("PROD0004", 450));
        order.addPurchase(new Purchase("PROD0006", 250));
        orderQueue.add(order);

        long expResult = new Date().getTime();
        long result = order.getTimeReceived().getTime();
        assertTrue(Math.abs(result - expResult) < 1000);
    }

    @Test
    public void WhenCustomerNameAndIdDoNotExistThrowException() {
        boolean exThrow = false;
        OrderQueue orderQueue = new OrderQueue();
        Order order = new Order("", "");
        order.addPurchase(new Purchase("CPRO0000", 300));
        order.addPurchase(new Purchase("CPRO0000", 300));
        try {
            orderQueue.add(order);
        } catch (Exception ex) {
            exThrow = true;
        }

        assertTrue(exThrow);

    }

    @Test
    public void WhenListOfPurchasesDontExistThrowException() {
        boolean exThrow = false;
        OrderQueue orderQueue = new OrderQueue();
        Order order = new Order("CUST00001", "Lewis Menelaws");
        try {
            orderQueue.add(order);
        } catch (Exception ex) {
            exThrow = true;
        }
        assertTrue(exThrow);

    }

    @Test
    public void RequestForOrderInSystemThenReturnOrder() throws Exception {
        OrderQueue orderQueue = new OrderQueue();
        Order order = new Order("CUST00001", "Lewis Menelaws");
        order.addPurchase(new Purchase("CPRO0000", 300));
        order.addPurchase(new Purchase("CPRO0000", 300));
        orderQueue.add(order);
        orderQueue.setTimeReceived(order);
        Order result = order;
        Order exResult = orderQueue.returnQueue();
        assertEquals(result, exResult);
    }

    @Test
    public void WhenNoOrdersInSystemReturnNull() {
        OrderQueue orderQueue = new OrderQueue();
        Order exResult = orderQueue.returnQueue();
        assertEquals(exResult, null);
    }

    @Test 
    public void RequestOrderWithTimeRecievedAndSetTimeToNow() throws Exception{
        OrderQueue orderQueue = new OrderQueue();
        Order order = new Order("CUST00001", "Lewis Menelaws");
        order.addPurchase(new Purchase("CPRO0000", 300));
        order.addPurchase(new Purchase("CPRO0000", 300));
        orderQueue.add(order);
        orderQueue.setTimeReceived(order);
        orderQueue.orderProcessed(order);
        orderQueue.setTimeProcessed(order);
        long exResult = new Date().getTime();
        long result = order.getTimeProcessed().getTime();
        assertTrue(Math.abs(result - exResult) < 1000);
    }
    
}

