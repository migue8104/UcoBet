package co.edu.uco.UcoBet.generales.crosscutting.exceptions.messageCatalog.data;

import static co.edu.uco.UcoBet.generales.crosscutting.helpers.TextHelper.concatenate;
import static co.edu.uco.UcoBet.generales.crosscutting.helpers.TextHelper.UNDERLINE;;

public enum CodigoMensaje {

	M00001(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00001", true),
	M00002(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00002", true),
	M00003(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00003", true),
	M00004(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00004", true),
	M00005(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00006", true),
	M00006(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00005", true),
	M00007(TipoMensaje.TECNICO, CategoriaMensaje.EXITO, "00007", true);


	private TipoMensaje tipo;
	private CategoriaMensaje categoria;
	private String codigo;
	private boolean base;

	private CodigoMensaje(TipoMensaje tipo, CategoriaMensaje categoria, String codigo, boolean base) {
		setTipo(tipo);
		setCategoria(categoria);
		setCodigo(codigo);
		setBase(base);
	}

	public final TipoMensaje getTipo() {
		return tipo;
	}

	public final CategoriaMensaje getCategoria() {
		return categoria;
	}

	public final String getCodigo() {
		return codigo;
	}

	public final boolean isBase() {
		return base;
	}

	private final void setTipo(TipoMensaje tipo) {
		this.tipo = tipo;
	}

	private final void setCategoria(CategoriaMensaje categoria) {
		this.categoria = categoria;
	}

	private final void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	private final void setBase(boolean base) {
		this.base = base;
	}

	public String getIdentificador() {
		return concatenate(getTipo().name(), UNDERLINE, getCategoria().name(), UNDERLINE, getCodigo());
	}

}
