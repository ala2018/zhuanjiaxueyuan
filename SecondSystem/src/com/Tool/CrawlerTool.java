package com.Tool;

import java.util.Set;
import java.util.Stack;
import java.util.Vector;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import edu.uci.ics.crawler4j.url.WebURL;

public class CrawlerTool extends WebCrawler {
	
	
private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg|png|mp3|zip|gz))$");  //正则表达式的对比模式
	
static String key=null;    //关键字
	static Vector<String> htmlBuffer=null;//匹配后存储区域

	
	public String getKey() {
		return key;
	}

	static public void setKey(String k) {
		key = k;
	}

	static	public Vector<String> getHtmlBuffer() {
		return htmlBuffer;
	}

	static	public void setHtmlBuffer(Vector<String> hbuffer) {
		htmlBuffer = hbuffer;
	}

	/*
	 * key与标题匹配,返回匹配长度
	 * 
	 */ 
	      
	    public  int getLCS(String x, String y){  
	          
	        char[] s1 = x.toCharArray();  
	        char[] s2 = y.toCharArray();  
	        int[][] array = new int[x.length()+1][y.length()+1];//此处的棋盘长度要比字符串长度多加1，需要多存储一行0和一列0  
	                  
	        for(int j = 0; j < array[0].length; j++){//第0行第j列全部赋值为0  
	            array[0][j] = 0;  
	        }  
	        for(int i = 0; i < array.length; i++){//第i行，第0列全部为0  
	            array[i][0] = 0;  
	        }  
	          
	        for(int m = 1; m < array.length; m++){//利用动态规划将数组赋满值  
	            for(int n = 1; n < array[m].length; n++){  
	                if(s1[m - 1] == s2[n - 1]){  
	                    array[m][n] = array[m-1][n-1] + 1;//动态规划公式一  
	                }else{  
	                    array[m][n] = max(array[m -1][n], array[m][n -1]);//动态规划公式二  
	                }  
	            }  
	        }  
	        return array[x.length()][y.length()];
	        
//	      for(int m = 0; m < array.length; m++){//将数组赋满值,这样可以从右下角开始遍历找出最大公共子序列  
//	          for(int n = 0; n < array[m].length; n++){  
//	              System.out.print(array[m][n]);  
//	          }  
//	          System.out.println();  
//	      }  
	  /*      Stack stack = new Stack();  
	        int i = x.length() - 1;  
	        int j = y.length() - 1;  
	          
	        while((i >= 0) && (j >= 0)){  
	            if(s1[i] == s2[j]){//字符串从后开始遍历，如若相等，则存入栈中  
	                stack.push(s1[i]);  
	                i--;  
	                j--;  
	            }else{  
	                if(array[i+1][j] > array[i][j+1]){//如果字符串的字符不同，则在数组中找相同的字符，注意：数组的行列要比字符串中字符的个数大1，因此i和j要各加1  
	                    j--;  
	                }else{  
	                    i--;  
	                }  
	            }  
	        }  
	          
	        while(!stack.isEmpty()){//打印输出栈正好是正向输出最大的公共子序列  
	            System.out.print(stack.pop());  
	        }    
	        
	           */
	    }  
	      
	    /*
	     * 
	     * 比较key在文章出现的频率
	     */
		/*
		 * key与标题匹配,返回匹配长度
		 * 
		 */ 
		      
		    public  int getKOP(String x, String y){  
		          
		        char[] s1 = x.toCharArray(); 
		        char[] s2 = y.toCharArray();  
		        int[][] array = new int[x.length()+1][y.length()+1];//此处的棋盘长度要比字符串长度多加1，需要多存储一行0和一列0  
		                  
		        for(int j = 0; j < array[0].length; j++){//第0行第j列全部赋值为0  
		            array[0][j] = 0;  
		        }  
		        for(int i = 0; i < array.length; i++){//第i行，第0列全部为0  
		            array[i][0] = 0;  
		        }  
		          
		        for(int m = 1; m < array.length; m++){//利用动态规划将数组赋满值  
		            for(int n = 1; n < array[m].length; n++){  
		                if(s1[m - 1] == s2[n - 1]){  
		                    array[m][n] = array[m-1][n-1] + 1;//动态规划公式一  
		                }else{  
		                    array[m][n] =array[m -1][n-1]; //动态规划公式二  
		                }  
		            }  
		        }  
		                      int k=0;
		        for(int j = 0; j < array[0].length; j++){ //array[0].length 列长度
		        	if(array[array.length][j]>=2)         //array.length 行长度
		        		k++;
		        }     
		                 
		        return k;
		    }
	    
	    /*
	     * 
	     * 比较大小方法
	     */
	    public  int max(int a, int b){//比较(a,b)，输出大的值  
	        return (a > b)? a : b;  
	    }  

	
	/**
	 * 这个方法有两个参数。第一个参数是我们发现的新的URL的页面并且第二个参数是新的URL。
	 * 你应该实现这个方法去指定这个被给的URL是不是应该去爬取。在这个例子中，我们指导
	 * 爬虫去忽视有CSS，JS，git等的URL并且知识获得了以“http://www.ics.uci.edu/”
	 * 开头的URL。在这种情况下，我们不需要用参考页面这个参数来做决定。
	 */
	 /** 
     *   根据url进行网页的解析，对返回为TRUE的网页进行抓取 
     *   第一个参数referringPage封装了当前爬取的页面信息 
     *   第二个参数封装了当前爬取页面的url信息 
     */  
	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
		String href = url.getURL().toLowerCase();
		return !FILTERS.matcher(href).matches() && href.startsWith("http://news.china.com/");
	}

	/**
	 * 这个功能是抓取准备被你的项目处理的页面
	 */
	
    /** 
     * 解析网页内容，page类包含了丰富的方法，可以利用这些方法得到网页的内容和属性 
     * 当我们爬取到我们需要的页面，这个方法会被调用，我们可以随意处理页面 
     * page 封装了所有页面信息 
     * 
     */  
	@Override
	public void visit(Page page) {
		String url = page.getWebURL().getURL();
		System.out.println("URL: " + url);

		if (page.getParseData() instanceof HtmlParseData) {
			HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
			String text = htmlParseData.getText();
			String html = htmlParseData.getHtml();
			Set<WebURL> links = htmlParseData.getOutgoingUrls();

			//System.out.println("Text length: " + text.length());
			//System.out.println("Html length: " + html.length());
			//System.out.println("Number of outgoing links: " + links.size());
			
		
			Document doc = Jsoup.parse(html);
			String title = doc.selectFirst("title").text();
			String c=doc.selectFirst("div[id=\"chan_newsDetail\"]").text();
			        int same=getLCS(key,title);
			       //int same=0;
			if(3*same>key.length()||(getLCS(key,c)*3>key.length())) {
			Element link=doc.selectFirst("p");
                       link.html("<a target=\"_blank\" href=\""+url+"\">"+title+"</a>");
			    	   htmlBuffer.add(link.outerHtml());
			    	   
			
			           System.out.println(link.outerHtml());
			           
			}   
	/*		for (Element link : linkss) {
			//String linkHref =link.attr("href");
			String linkText =link.attr("title");
			System.out.println("测试: " +linkText );
			}
			*/
		}
	}

	
	public CrawlController configController(int deep) throws Exception {
		//定义爬虫存储的位置  
        String crawlStorageFolder = "/Data/crawl/root";  
        //定义爬虫配置  
        CrawlConfig config = new CrawlConfig();  
        //设置爬虫文件存储位置  
        config.setCrawlStorageFolder(crawlStorageFolder); 
        
        config.setPolitenessDelay(2); // 0.1秒爬一次
        
        config.setMaxPagesToFetch(deep); // 爬取深度-1无限
        /* 
         * Instantiate the controller for this crawl. 
         */  
        //实例化页面获取器  
        PageFetcher pageFetcher = new PageFetcher(config);  
        //实例化爬虫机器人配置,比如可以设置user-agent
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();  
        
        //实例化爬虫机器人对目标服务器的配置，每个网站都有一个robots.txt文件  
        //规定了该网站哪些页面可以爬，哪些页面禁止爬，该类是对robots.txt规范的实现  
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);  
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);  
   
        /* 
         * For each crawl, you need to add some seed urls. These are the first 
         * URLs that are fetched and then the crawler starts following links 
         * which are found in these pages 
         */ 
        
        //配置爬取种子页面，就是规定从哪里开始爬，可以配置多个种子页面 
        controller.addSeed("http://news.china.com/");  
     //   controller.addSeed("http://www.ics.uci.edu/~welling/");  
     //  controller.addSeed("http://www.ics.uci.edu/");  

		return controller;
		
	}
	
	public void startController(CrawlController controller,int numberOfCrawlers) {
        /* 
         * Start the crawl. This is a blocking operation, meaning that your code 
         * will reach the line after this only when crawling is finished. 
         */  
		             controller.start(CrawlerTool.class, numberOfCrawlers);
		             // 休息10秒
		             //Thread.sleep(10 * 1000);
		           
		            // System.out.println("休息10秒");
		          
		             // 停止爬取
		             //controller.shutdown();
		             System.out.println("停止爬取");
		              
		             // 等待结束任务
		             controller.waitUntilFinish();
	}


}
