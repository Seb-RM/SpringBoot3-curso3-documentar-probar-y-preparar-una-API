package med.voll.api.domain.consulta.validaciones;

import com.sun.jdi.connect.VMStartException;
import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.DatosReservaConsulta;

import java.time.DayOfWeek;

public class ValidacionFueraDelHorario {

    public void validar(DatosReservaConsulta datos) {
        var fechaconsulta = datos.fecha();
        var domingo = fechaconsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var horarioAntesDeAperturaClinica = fechaconsulta.getHour() < 7;
        var horarioDespuesDeCierreClinica = fechaconsulta.getHour() > 18;
        if(domingo || horarioAntesDeAperturaClinica || horarioDespuesDeCierreClinica) {
            throw new ValidacionException("Horario seleccionado fuera del horario de atención de la clínica");
        }
    }
}
