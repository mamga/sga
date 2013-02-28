package gov.pr.seab.sga.dao;

import gov.pr.seab.sga.dto.ParecerTramitacaoDTO;
import gov.pr.seab.sga.dto.ProtocoloDTO;
import gov.pr.seab.sga.dto.TramitacaoProtocoloDTO;
import gov.pr.seab.sga.bean.Protocolo;

import java.util.Collection;
import java.util.List;

public interface ProtocoloDAO {
	
	public Collection<Protocolo> listar(ProtocoloDTO protocoloDTO);
	
	public Protocolo obter(ProtocoloDTO protocoloDTO);
	
	public List<TramitacaoProtocoloDTO> listarTramitacao(ProtocoloDTO protocoloDTO);
	
	public ParecerTramitacaoDTO listarParecer(String parecerId);

}
