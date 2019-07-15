package riscv;

import ghidra.app.util.bin.format.elf.ElfConstants;
import ghidra.app.util.bin.format.elf.ElfHeader;
import ghidra.app.util.bin.format.elf.ElfLoadHelper;
import ghidra.app.util.bin.format.elf.extend.ElfExtension;
import ghidra.program.model.lang.Language;

public class RISCV_ElfExtension extends ElfExtension {

	@Override
	public boolean canHandle(ElfHeader elf) {
		return elf.e_machine() == ElfConstants.EM_RISCV;
	}

	@Override
	public boolean canHandle(ElfLoadHelper elfLoadHelper) {
		Language language = elfLoadHelper.getProgram().getLanguage();
		return canHandle(elfLoadHelper.getElfHeader()) &&
				"RISCV".equals(language.getProcessor().toString());
	}

	@Override
	public String getDataTypeSuffix() {
		return "_RV";
	}

}
