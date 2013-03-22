package dbfit.util;

import fit.Binding;
import fit.Fixture;
import fit.Parse;

import static dbfit.util.SymbolUtil.isSymbolGetter;

public class SymbolAccessSetBinding extends Binding.SetBinding {

	@Override
	public void doCell(Fixture fixture, Parse cell) throws Throwable {
		String text=cell.text();
		if (isSymbolGetter(text)){
			Object value=dbfit.util.SymbolUtil.getSymbol(text.substring(2).trim());
			cell.addToBody(Fixture.gray(" = "+String.valueOf(value)));
			adapter.set(value);
			return;
		}
		super.doCell(fixture, cell);
	}

}
