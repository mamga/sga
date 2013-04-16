package gov.pr.seab.sga.dao;

import gov.pr.seab.sga.dto.ParecerTramitacaoDTO;
import gov.pr.seab.sga.dto.ProtocoloDTO;
import gov.pr.seab.sga.dto.TramitacaoProtocoloDTO;
import gov.pr.seab.sga.bean.ProtocoloAAX;

import java.util.Collection;
import java.util.List;

public interface ProtocoloDAO {
	
	public Collection<ProtocoloAAX> listar(ProtocoloDTO protocoloDTO) throws Exception;
	
	public ProtocoloAAX obter(ProtocoloDTO protocoloDTO) throws Exception;
	
	public List<TramitacaoProtocoloDTO> listarTramitacao(ProtocoloDTO protocoloDTO) throws Exception;
	
	public ParecerTramitacaoDTO listarParecer(String parecerId);

}
