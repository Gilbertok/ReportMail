package br.com.marlan.util;

import com.itextpdf.tool.xml.pipeline.html.AbstractImageProvider;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import com.itextpdf.tool.xml.pipeline.html.ImageProvider;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.exceptions.CssResolverException;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;

public class Html2Pdf {
	
	private final InputStream is;
    private ImageProvider imProvider;
    private CSSResolver cssResolver;
    
    public Html2Pdf(InputStream is) throws TransformerConfigurationException, TransformerException {
        this.is = is;
        cssResolver = XMLWorkerHelper.getInstance().getDefaultCssResolver(true);
        this.imProvider = new Base64ImageProvider();
    }   
 
    public Html2Pdf(String html) throws TransformerException {
        this(new ByteArrayInputStream(html.getBytes()));
    }
 
    public void setImageProvider(ImageProvider imProvider) {
        this.imProvider = imProvider;
    }
 
    public void addCss(String css) throws CssResolverException {
        cssResolver.addCss(css, Boolean.TRUE);
    }
    
    public void convert(OutputStream file) throws DocumentException, IOException {       
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, file);
        // step 3
        document.open();
        // step 4        
 
        // HTML
        HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
        htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
        if (imProvider != null) {
            htmlContext.setImageProvider(imProvider);
        }
 
        // Pipelines
        PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
        HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
        CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);
 
        // XML Worker
        XMLWorker worker = new XMLWorker(css, true);
        XMLParser p = new XMLParser(worker);
        p.parse(is);
 
        // step 5
        document.close();
    }
    
    public void convert(File os) throws FileNotFoundException, IOException, DocumentException {
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(os))) {
            convert(out);
        }
    }
 
    public static void main(String[] args) throws IOException, FileNotFoundException, DocumentException, TransformerException, CssResolverException {
//        Html2Pdf pdf = new Html2Pdf(new File("resources/email_pedidos.html"));
        Html2Pdf pdf = new Html2Pdf(getTemplateHtml());
        pdf.setImageProvider(new Base64ImageProvider());
        pdf.convert(new File("resources/out.pdf"));
    }
    
    private static String getTemplateHtml() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("resources/email_pedidos.html"));
		StringBuilder builder = new StringBuilder();
		String line = "";
		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}
		reader.close();
		return builder.toString();
	}
    
    static class Base64ImageProvider extends AbstractImageProvider {
    	 
        @Override
        public Image retrieve(String src) {
            int pos = src.indexOf("base64,");
            try {
                if (src.startsWith("data") && pos > 0) {
                    byte[] img = Base64.decode(src.substring(pos + 7));
                    return Image.getInstance(img);
                } else {
                    return Image.getInstance(src);
                }
            } catch (BadElementException | IOException ex) {
                return null;
            }
        }
 
        @Override
        public String getImageRootPath() {
            return null;
        }
    }

}
