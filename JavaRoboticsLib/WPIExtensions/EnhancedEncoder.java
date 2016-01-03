package JavaRoboticsLib.WPIExtensions;

import JavaRoboticsLib.Utility.Derivative;
import edu.wpi.first.wpilibj.Encoder;

/**
* An encoder with corrected rate calculation
*/
public class EnhancedEncoder extends Encoder 
{
    private Derivative m_velocityFilter = new Derivative();
    /**
    * Delta-time value to determine velocity. Set negative to determine dt automatically.
    */
    public void setDt(double value) {
        m_velocityFilter.Dt = value;
    }

    /**
    * CSharpRoboticslib.Extras.EnhancedEncoder
    * 
    *  @param aChannel 
    *  @param bChannel
    */
    public EnhancedEncoder(int aChannel, int bChannel) {
        super(aChannel, bChannel);
        m_velocityFilter = new Derivative();
    }

    /**
    * Gets the velocity reported by the encoder.
    * 
    *  @return Derivative of the distance
    */
    public double getRate() {
        return m_velocityFilter.Get(GetDistance());
    }

    /**
    * Resets the encoder and derivative
    */
    public void reset() {
        super.Reset();
        m_velocityFilter.ReInitialize();
    }

}

