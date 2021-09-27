package idat.edu.pe.daa2.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import idat.edu.pe.daa2.entidades.Solicitud;

@Component("solicitudes/listar")
public class ListarSolicitudesPdf extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		@SuppressWarnings("unchecked")
		List<Solicitud> solicitud = (List<Solicitud>) model.get("solicitudes");
		
		document.setPageSize(PageSize.LETTER.rotate());
		document.setMargins(-20, -20, 30, 20);
		document.open();
		
		PdfPTable tablaTitulo = new PdfPTable(1);
		PdfPCell celda= null;
		
		Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,Color.BLUE);
		Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD,12,Color.BLUE);
		Font fuenteDataCeldas = FontFactory.getFont(FontFactory.COURIER,10,Color.BLACK);
		
		celda = new PdfPCell(new Phrase("LISTADO DE SOLICITUDES", fuenteTitulo));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(40,190,138));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(30);
		
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);
		
		PdfPTable tablaSolicitudes = new PdfPTable(6);
		
		tablaSolicitudes.setWidths(new float[] {1f,1f,1f,1f,1f,1f});
		
		celda= new PdfPCell(new Phrase("Nombre", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaSolicitudes.addCell(celda);
		
		celda= new PdfPCell(new Phrase("Precio (Unid.)", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaSolicitudes.addCell(celda);
		
		celda= new PdfPCell(new Phrase("Talla", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaSolicitudes.addCell(celda);
		
		celda= new PdfPCell(new Phrase("Cantidad", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaSolicitudes.addCell(celda);
		
		celda= new PdfPCell(new Phrase("Fecha de Solicitud", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaSolicitudes.addCell(celda);
		
		
		celda= new PdfPCell(new Phrase("Telefono de Cliente", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaSolicitudes.addCell(celda);
		
		
		solicitud.forEach(sol ->{
			
			
			tablaSolicitudes.addCell(sol.getZapatilla().getNombre());
			tablaSolicitudes.addCell(sol.getZapatilla().getPrecio().toString());
			tablaSolicitudes.addCell(sol.getTalla().toString());
			tablaSolicitudes.addCell(sol.getCantidad().toString());
			tablaSolicitudes.addCell(sol.getFecha().toString());
			tablaSolicitudes.addCell(sol.getUsuario().getTelefono() + " " + "-" + 	sol.getUsuario().getNombre());
		});
		
		
		
		document.add(tablaTitulo);
		document.add(tablaSolicitudes);
	}

}
