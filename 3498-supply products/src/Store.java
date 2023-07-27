// You can import any package needed here


public class Store {

    private final Function function;
    // You can add any attribute needed here
    private int products;
    private Product product;
    private Product product2;
    private Product product3;
    
    private final static int N = 3; 
    
    private static class Product {
    	boolean ready = false;
    }

    public Store(Function function) {
        this.function = function;
        // Init here
        this.products = 0;
        this.product = new Product();
        this.product2 = new Product();
        this.product3 = new Product();
    }

    public void provider() throws InterruptedException {
        // You can call `function.placeProductX()` to place a product X on table.
        // For example: `function.placeProduct1()` to place a produce1 on table.
        // --- write your code here ---
    	synchronized(product) {
	    	if (product.ready) {
	        	product.wait();
	        }
    	}
        
    	synchronized(product2) {
    		if (product2.ready) {
    			product2.wait();
    		}
        }
    	
    	synchronized(product3) {
    		if (product3.ready) {
    			product3.wait();
    		}
    	}
    	
    	//System.out.println(products);
        
        if (products % N == 0) {
        	synchronized(product) {
        		function.placeProduct1();
        		product.ready = true;
        		product.notify();
        	}
        } else if (products % N == 1) {
        	synchronized(product2) {
        		function.placeProduct2();
        		product2.ready = true;
        		product2.notify();
        	}
        } else if (products % N == 2) {
        	synchronized(product3) {
        		function.placeProduct3();
        		product3.ready = true;
        		product3.notify();
        	}
        }
        products++;
    }

    public void customer1() throws InterruptedException {
        // You can call `function.takeProduct1()` to take a product1
        // You can call `function.checking()` to check products
        // --- write your code here ---
        synchronized(product) {
	    	if (!product.ready) {
	    		product.wait();
	        }
	    	function.takeProduct1();
        	function.checking();
        	product.ready = false;
        	product.notify();
        }
    }

    public void customer2() throws InterruptedException {
        // You can call `function.takeProduct2()` to take a product2
        // You can call `function.checking()` to check products
        // --- write your code here ---
    	synchronized(product2) {
	    	if (!product2.ready) {
	    		product2.wait();
	        }
	    	function.takeProduct2();
        	function.checking();
        	product2.ready = false;
        	product2.notify();
    	}
    }

    public void customer3() throws InterruptedException {
        // You can call `function.takeProduct3()` to take a product3
        // You can call `function.checking()` to check products
        // --- write your code here ---
    	synchronized(product3) {
	    	if (!product3.ready) {
	    		product3.wait();
	        }
	    	function.takeProduct3();
        	function.checking();
        	product3.ready = false;
        	product3.notify();
    	}
    }

}
